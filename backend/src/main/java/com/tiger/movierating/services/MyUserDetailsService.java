package com.tiger.movierating.services;

import com.tiger.movierating.repos.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    final UserRepo userRepo;

    public MyUserDetailsService( UserRepo userRepo ){
        this.userRepo = userRepo;
    }

    public com.tiger.movierating.models.UserDetails.User createUser( com.tiger.movierating.models.UserDetails.User user ){
        return userRepo.save( user );
    }

    @Override
    public UserDetails loadUserByUsername( String s ) throws UsernameNotFoundException{

//        return new User( "admin", "admin", new ArrayList<>() );
        System.out.println("Loading user by username where username is: "+s);
        com.tiger.movierating.models.UserDetails.User byUsername = userRepo.findByUsername( s );
        System.out.println("Loaded user by username is: "+byUsername);
        return new User( byUsername.getUsername(), byUsername.getPassword(), new ArrayList<>());
    }


}