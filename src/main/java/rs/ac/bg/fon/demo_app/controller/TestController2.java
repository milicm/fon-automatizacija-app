package rs.ac.bg.fon.demo_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {

    @GetMapping("/test2")
    public String test2() {
        return "Hello, World! from TestController2!";
    }
}
