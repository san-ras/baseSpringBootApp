package lt.techin.examSR.service;


import lt.techin.examSR.exception.EmailAlreadyExistsException;
import lt.techin.examSR.exception.UsernameAlreadyExistsException;
import lt.techin.examSR.model.User;
import lt.techin.examSR.repository.UserRepository;
import lt.techin.examSR.rest.UserLoginRequest;
import lt.techin.examSR.rest.UserSignupRequest;
import lt.techin.examSR.rest.dto.UserDto;
import lt.techin.examSR.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Map<String, String> login(UserLoginRequest userLoginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginRequest.getUsername(), userLoginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserDto userDto = new UserDto(userRepository.findByUsername(userDetails.getUsername()));
        return jwtService.generateToken(userDto);
    }

    public Map<String, String> register(UserSignupRequest userSignupRequest) throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
        if (userRepository.findByUsername(userSignupRequest.getUsername()) != null) {
            throw new UsernameAlreadyExistsException("User with name: " + userSignupRequest.getUsername() + ", already exist.");
        }
        if (userRepository.findByEmail(userSignupRequest.getEmail()) != null) {
            throw new EmailAlreadyExistsException("User with email: " + userSignupRequest.getEmail() + ", already exist.");
        }

        User newUser = new User();
        newUser.setUsername(userSignupRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(userSignupRequest.getPassword()));
        newUser.setEmail(userSignupRequest.getEmail());
        userRepository.save(newUser);

        return Map.of("message", "User successfully created.");
    }
}
