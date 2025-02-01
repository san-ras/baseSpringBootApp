package lt.techin.examSR.security;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lt.techin.examSR.exception.EmailAlreadyExistsException;
import lt.techin.examSR.exception.UsernameAlreadyExistsException;
import lt.techin.examSR.rest.UserLoginRequest;
import lt.techin.examSR.rest.UserSignupRequest;
import lt.techin.examSR.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(userLoginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signup(@RequestBody @Valid UserSignupRequest userSignupRequest) throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(userSignupRequest));
    }



}