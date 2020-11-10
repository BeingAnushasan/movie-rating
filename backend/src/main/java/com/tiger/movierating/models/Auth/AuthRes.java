package com.tiger.movierating.models.Auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthRes {
    private final String jwt;

}
