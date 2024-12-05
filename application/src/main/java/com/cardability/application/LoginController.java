package com.cardability.application;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController
{
    @Autowired
    private AuthService authService;


    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        try{
            auth
        }

    }
}
