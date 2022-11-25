package com.bright.hibernatejpa.models;

/*
 * @Project Name: HibernateJPADemo
 * @Author: Okechukwu Bright Onwumere
 * @Created: 24/11/2022
 */


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String details;
    private LocalDateTime postDate;

    /* This means many users can have one location. The *many* is the class and the *one* is the field. The class
     * should handle the relationship. Wherever we put this annotation, it is that entity that would handle the mapping.
     * In this case, Post table would have another field called user_id. */
    @ManyToOne
    //@JoinColumn(name = "user_id")
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;

    private Long userid;

    /* To break infinite recursion loop, the @JsonManagedReference is used on the OneToMany side while the
     * @JsonBackReference is used at the @ManyToOne side. @JsonManagedReference is the forward part of the
     * mapping/reference and the data gets serialized normally. @JsonBackReference is the backward side of the
     * mapping and the data does not get serialized. They are added on the getter methods.
     * */
    @JsonBackReference
    public User getUser() {
        return user;
    }
}
