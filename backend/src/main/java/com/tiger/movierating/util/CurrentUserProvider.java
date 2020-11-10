package com.tiger.movierating.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class CurrentUserProvider {
    String username;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    public String getUsername(){
        if (principal instanceof UserDetails) {
            return username = ((UserDetails) principal).getUsername();
        } else {
            return username = principal.toString();
        }
    }


}
