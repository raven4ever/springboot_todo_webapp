package com.springboot.jspapp.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("adrian") && password.equalsIgnoreCase("adrian");
    }
}
