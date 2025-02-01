package lt.techin.examSR.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController {


    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/checkAuth")
    public String checkAuth() {
        return "successfully logged in";
    }

    //todo delete class after all is done
}

