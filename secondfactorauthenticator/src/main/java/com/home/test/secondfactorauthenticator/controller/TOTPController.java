package com.home.test.secondfactorauthenticator.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/totptester")
public class TOTPController {

    @GetMapping("/generate-secret")
    public String getSecretKey(){
        return "hello";
    }

    @GetMapping("/bar-code")
    public String getBarCode(){
        return "bar code";
    }

    @GetMapping("/totp")
    public String getTOTP(){
        return "test-otp";
    }
    @PostMapping("/validate")
    public String validate(@RequestParam String totp){
        return "success";
    }

}
