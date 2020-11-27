package com.tiger.movierating.models.UserDetails;

import com.tiger.movierating.models.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table()
@Getter
@Setter
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    @Column(name = "name")
//    private UserRoles userRoles;
    private  String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "permission_role", joinColumns = {
//            @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
//            @JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission> permissions;




}