package com.tiger.movierating.models.UserDetails;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table()
@Data
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column()
    private String name;
//    private UserPermissions userPermissions;
}