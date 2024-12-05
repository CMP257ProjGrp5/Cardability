package com.cardability.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class LoginController
{
    @GetMapping("/login")
    public String showLoginPage(@RequestParam(required = false) String error) {
        if ("accessDenied".equals(error)) {
            return "login?error=accessDenied";
        }
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               RedirectAttributes attributes) {
        // Here you would typically validate the credentials against your database
        // For this example, we'll just check if the username matches "user"
        if (username.equals("user") && password.equals("password")) {
            attributes.addFlashAttribute("message", "Login successful!");
            return "redirect:/";
        } else {
            attributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/login?error=accessDenied";
        }
    }
}

