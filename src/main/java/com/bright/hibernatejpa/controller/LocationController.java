package com.bright.hibernatejpa.controller;

/*
 * @Project Name: HibernateJPADemo
 * @Author: Okechukwu Bright Onwumere
 * @Created: 24/11/2022
 */


import com.bright.hibernatejpa.models.Location;
import com.bright.hibernatejpa.models.User;
import com.bright.hibernatejpa.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/locations/{id}")
    public Optional<Location> getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @GetMapping("/locations/{id}/users")
    public List<User> getUsersByLocation(@PathVariable Long id){
        Optional<Location> location = locationService.getLocationById(id);
        return location.map(Location::getUsers).orElse(null);
    }

    @PostMapping("/locations/addNew")
    public void addLocation(@RequestBody Location location) {
        locationService.addLocation(location);
    }

    @PutMapping("/locations/{id}/update")
    public void updateLocation(@RequestBody Location location) {
        locationService.updateLocation(location);
    }

}
