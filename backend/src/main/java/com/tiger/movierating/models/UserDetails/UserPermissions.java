package com.tiger.movierating.models.UserDetails;


import org.springframework.security.core.GrantedAuthority;


public enum UserPermissions implements GrantedAuthority {
    create_USER,
    update_USER,
    delete_USER,
    view_USER,
    create_MOVIE,
    update_MOVIE,
    delete_MOVIE;

    private String permissions;

    @Override
    public String getAuthority(){
        return permissions;
    }

    public String getPermissions(){
        return permissions;
    }

}
