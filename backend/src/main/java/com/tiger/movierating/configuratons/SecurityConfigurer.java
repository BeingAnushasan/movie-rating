package com.tiger.movierating.configuratons;

import com.tiger.movierating.filter.JWTRequestFilter;
import com.tiger.movierating.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    private final MyUserDetailsService myUserDetailService;

    private final JWTRequestFilter jwtRequestFilter;

    public SecurityConfigurer( MyUserDetailsService myUserDetailService, JWTRequestFilter jwtRequestFilter ){
        this.myUserDetailService = myUserDetailService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception{
        auth.userDetailsService( myUserDetailService );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception{
        http.csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers( "/security/*" ).permitAll()
//                .antMatchers( "/authenticate/signup" ).permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS );

        http.addFilterBefore( jwtRequestFilter, UsernamePasswordAuthenticationFilter.class );
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins( Arrays.asList( "*" ) );
        configuration.setAllowedMethods( Arrays.asList( "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS" ) );
        configuration.setAllowedHeaders( Arrays.asList( "authorization", "content-type", "x-auth-token" ) );
        configuration.setExposedHeaders( Arrays.asList( "x-auth-token" ) );
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration( "/**", configuration );
        return source;
    }

}
//abhiyantimilsina96@gmail.com
//badtoseecdream1