package com.bright.hibernatejpa.models;

/*
 * @Project Name: HibernateJPADemo
 * @Author: Okechukwu Bright Onwumere
 * @Created: 24/11/2022
 */


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users") //A table with name user cannot be created hence *user*
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    /* This means many users can have one location. The *many* is the class and the *one* is the field. The class
     * should handle the relationship. Wherever we put this annotation, it is that entity that would handle the mapping.
     * In this case, User table would have another field called location_id. */
    @ManyToOne
    private Location location;

    /* The mappedBy is an attribute of the @OneToMany relationship. You use the mappedBy to tell the @OneToMany
     * attribute that the relationship has already been handled using a foreign key in the corresponding entity. In
     * this way, an additional table is not created
     */
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
