package com.tiger.movierating.models.UserDetails;


import com.google.common.collect.Sets;

import java.util.Set;

import static com.tiger.movierating.models.UserDetails.UserPermissions.*;

public enum UserRoles {
    role_ADMIN( Sets.newHashSet( view_USER, update_USER, delete_USER, create_MOVIE, update_MOVIE, delete_MOVIE ) ),
    role_USER( Sets.newHashSet( create_MOVIE, delete_MOVIE, update_MOVIE, update_USER, view_USER ) );

    private final Set<UserPermissions> permissions;

    UserRoles( Set<UserPermissions> permissions ){
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions(){
        return permissions;
    }
}
