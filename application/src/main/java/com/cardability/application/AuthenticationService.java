package com.cardability.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authMan;

    @Autowired
    private UserService userService;

    public String login(String username, String password){
        Authentication authentication = authMan.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        if (authentication.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authentication);

            User currentUser = (User) authentication.getPrincipal();
            return "redirect:/user/" + currentUser.getId();
        }
        else{
            throw new RuntimeException("Invalid Login Credentials");
        }
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }

}
