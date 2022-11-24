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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
}
