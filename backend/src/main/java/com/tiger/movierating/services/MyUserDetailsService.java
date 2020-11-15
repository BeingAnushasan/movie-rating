package com.tiger.movierating.services;

import com.tiger.movierating.models.UserDetails.Permission;
import com.tiger.movierating.models.UserDetails.Role;
import com.tiger.movierating.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    final UserRepo userRepo;

    public MyUserDetailsService( UserRepo userRepo ){
        this.userRepo = userRepo;

    }

    public com.tiger.movierating.models.UserDetails.User createUser( com.tiger.movierating.models.UserDetails.User user ){
        user.setPassword( passwordEncoder.encode( user.getPassword() ) );
        return userRepo.save( user );
    }

    @Override
    public UserDetails loadUserByUsername( String s ) throws UsernameNotFoundException{

//        return new User( "admin", "admin", new ArrayList<>() );
        com.tiger.movierating.models.UserDetails.User byUsername = userRepo.findByUsername( s );
        System.out.println( "Loaded user by username is: " + byUsername );

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : byUsername.getRoles()){
            List<Permission> permissions = role.getPermissions();
            for (Permission permission: permissions){
                authorities.add( new SimpleGrantedAuthority( permission.getName() ) );
            }
        }

        System.out.println("Roles are :"+ authorities);

        return new User( byUsername.getUsername(), byUsername.getPassword(), authorities);
    }


}