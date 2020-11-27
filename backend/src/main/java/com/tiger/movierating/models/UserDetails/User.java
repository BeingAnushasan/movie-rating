package com.tiger.movierating.models.UserDetails;

import com.tiger.movierating.models.Movie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    //    @Column(name = "fullName")
    private String fullName;
    //    @Column(name = "phoneNumber")
    private String phoneNumber;
    //    @Column(name = "email")
    private String email;
    //    @Column(name = "username")
    private String username;
    //    @Column(name = "password")
    private String password;


    //    @Column(name = "enabled")
    private boolean enabled;
    //    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;
    //    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;
    //    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;


//        @JoinTable(name = "movies_user", joinColumns = {
//            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
//            @JoinColumn(name = "movie_id", referencedColumnName = "id")})
//    @OneToMany(targetEntity = Movie.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "um_fk", referencedColumnName = "id")
//    //    @OneToMany(mappedBy = "user")
//    private List<Movie> movies;

    //    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Movie> movie = new ArrayList<>();


}