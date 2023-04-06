package ru.netology.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.service.AuthService;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/logout")
@Validated
public class LogoutController {
    private final AuthService authService;

    public LogoutController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public void logout(@RequestHeader("auth-token") @NotBlank String authToken) {
        authService.logout(authToken);
    }
}
