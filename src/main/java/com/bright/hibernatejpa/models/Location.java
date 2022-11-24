package com.bright.hibernatejpa.models;

/*
 * @Project Name: HibernateJPADemo
 * @Author: Okechukwu Bright Onwumere
 * @Created: 24/11/2022
 */

import lombok.*;

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
    private Long id;
    private String name;

    /* The mappedBy is an attribute of the @OneToMany relationship. You use the mappedBy to tell the @OneToMany
     * attribute that the relationship has already been handled using a foreign key in the corresponding entity. In
     * this way, an additional table is not created
     */
    @OneToMany(mappedBy = "location")
    private List<User> users;  //This means list of all the users under the location
}
