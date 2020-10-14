package com.tiger.movierating.controllers;

import com.tiger.movierating.models.Auth.AuthReq;
import com.tiger.movierating.models.Auth.AuthRes;
import com.tiger.movierating.services.MyUserDetailsService;
import com.tiger.movierating.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/hello")
    public String hello(){
        return "Hello There";
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken( @RequestBody AuthReq authReq ) throws Exception{
        System.out.println( authReq.getUsername() );
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( authReq.getUsername(), authReq.getPassword() )
            );
        } catch (BadCredentialsException e) {
            throw new Exception( "Incorrect username or password", e );
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername( authReq.getUsername() );

        final String jwt = jwtUtil.generateToken( userDetails );

        ResponseEntity<AuthRes> authreqResponseEntity = ResponseEntity.ok( new AuthRes( jwt ) );
        System.out.println( authreqResponseEntity );
        return authreqResponseEntity;
    }
}
