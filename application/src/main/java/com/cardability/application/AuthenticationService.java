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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    public String login(String username, String password) {
        Authentication authentication = authenticateUser(username, password);
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User currentUser = (User) authentication.getPrincipal();
            return buildRedirectUrl(currentUser);
        } else {
            throw new RuntimeException("Invalid Login Credentials");
        }
    }

    private Authentication authenticateUser(String username, String password) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
    }

    private String buildRedirectUrl(User user) {
        return "redirect:/user/" + user.getId();
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }
}