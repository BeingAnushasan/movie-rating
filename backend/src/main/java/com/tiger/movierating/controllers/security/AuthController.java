package com.tiger.movierating.controllers.security;

import com.tiger.movierating.models.Auth.AuthReq;
import com.tiger.movierating.models.Auth.AuthRes;
import com.tiger.movierating.models.UserDetails.User;
import com.tiger.movierating.models.UserDetails.UserRoles;
import com.tiger.movierating.services.MyUserDetailsService;
import com.tiger.movierating.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/security")
@Transactional
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final MyUserDetailsService userDetailsService;

    private final JWTUtil jwtUtil;

    public AuthController( AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JWTUtil jwtUtil ){
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> createUser( @RequestBody User user ){
        System.out.println("Signup request for: "+user);
        user.getUserRoles().add( UserRoles.role_USER );
        userDetailsService.createUser( user );
        return new ResponseEntity( HttpStatus.CREATED );
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
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

        ResponseEntity<AuthRes> authReqResponseEntity = ResponseEntity.ok( new AuthRes( jwt ) );
        System.out.println( authReqResponseEntity );
        return authReqResponseEntity;
    }


}
