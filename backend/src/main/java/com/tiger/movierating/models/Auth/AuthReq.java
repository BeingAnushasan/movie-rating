package com.tiger.movierating.models.Auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthReq {
    private String username;
    private String password;


}
