package com.tiger.movierating.models.UserDetails;

import com.tiger.movierating.models.Movie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table()
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;


    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;

    @ElementCollection(fetch = FetchType.EAGER)
    Set<UserRoles> userRoles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Movie> movie = new ArrayList<>();


}