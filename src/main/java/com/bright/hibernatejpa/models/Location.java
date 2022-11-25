package com.bright.hibernatejpa.models;

/*
 * @Project Name: HibernateJPADemo
 * @Author: Okechukwu Bright Onwumere
 * @Created: 24/11/2022
 */

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String name;

    /* The mappedBy is an attribute of the @OneToMany relationship. You use the mappedBy to tell the @OneToMany
     * attribute that the relationship has already been handled using a foreign key in the corresponding entity. In
     * this way, an additional table is not created
     */
    @OneToMany(mappedBy = "location")
    private List<User> users;  //This means list of all the users under the location


    /* To break infinite recursion loop, the @JsonManagedReference is used on the OneToMany side while the
     * @JsonBackReference is used at the @ManyToOne side. @JsonManagedReference is the forward part of the
     * mapping/reference and the data gets serialized normally. @JsonBackReference is the backward side of the
     * mapping and the data does not get serialized. They are added on the getter methods.
     * */
    @JsonManagedReference
    public List<User> getUsers() {
        return users;
    }
}
