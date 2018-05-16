package com.example.demo.controllers;

import com.example.demo.services.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    private TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/createjwt")
    public ResponseEntity<String> getJwtToken() {
        return new ResponseEntity<>(tokenService.generate(), HttpStatus.OK);
    }

}
