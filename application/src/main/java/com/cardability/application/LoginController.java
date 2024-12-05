package com.cardability.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController
{
    @Autowired
    private AuthenticationService authService;


    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            String redirectUrl = authService.login(username, password);
            return redirectUrl;
        } catch (RuntimeException e) {
            model.addAttribute("error", "Login failed: " + e.getMessage());
            return "login";
        }
    }
}
