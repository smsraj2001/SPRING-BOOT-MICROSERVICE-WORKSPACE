package com.tvsmotor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.tvsmotor.dto.AuthRequest;
import com.tvsmotor.dto.VehicleDto;
import com.tvsmotor.entity.UserInfo;
import com.tvsmotor.service.JwtService;
import com.tvsmotor.service.UserInfoService;
import com.tvsmotor.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Public endpoint
    @GetMapping("/public/welcome")
    public String welcome() {
        return "Welcome! This endpoint is not secure.";
    }

    // Register new user (open for all)
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }

    // Admin: View all vehicles
    @GetMapping("/admin/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<VehicleDto> viewAllVehicles() {
        return vehicleService.viewAllVehicle();
    }

    // User: View vehicle by ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public VehicleDto getVehicleById(@PathVariable int id) {
        return vehicleService.viewVehicleById(id);
    }

    // Admin: Add a new vehicle
    @PostMapping("/admin/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public VehicleDto addVehicle(@RequestBody VehicleDto vehicleDto) {
        return vehicleService.addVehicle(vehicleDto);
    }

    // Admin: Update vehicle by ID
    @PutMapping("/admin/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public VehicleDto updateVehicle(@PathVariable int id, @RequestBody VehicleDto vehicleDto) {
        return vehicleService.updateVehicleById(id, vehicleDto);
    }

    // Admin: Delete vehicle by ID (soft delete)
    @DeleteMapping("/admin/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteVehicleById(@PathVariable int id) {
        return vehicleService.deleteVehicleById(id);
    }

    // Login to get token
    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
