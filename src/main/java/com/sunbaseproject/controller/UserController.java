package com.sunbaseproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbaseproject.JWTservice.JwtService;
import com.sunbaseproject.JWTservice.UserInfoService;
import com.sunbaseproject.entity.AuthRequest;
import com.sunbaseproject.entity.UserInfo;

@RestController
@RequestMapping("/auth") 
public class UserController {
	
	@Autowired
    private UserInfoService service; 
  
    @Autowired
    private JwtService jwtService; 
  
    @Autowired
    private AuthenticationManager authenticationManager; 
  
    @GetMapping("/welcome") 
    public String welcome() { 
        return "Welcome this endpoint is not secure"; 
    } 
  
    @PostMapping("/addNewUser") 
    public String addNewUser(@RequestBody UserInfo userInfo) { 
        return service.addUser(userInfo); 
    } 
  
    @GetMapping("/user/userProfile") 
    @PreAuthorize("hasAuthority('ROLE_USER')") 
    public String userProfile() { 
        return "Welcome to User Profile"; 
    } 
  
    @GetMapping("/admin/adminProfile") 
    @PreAuthorize("hasAuthority('ROLE_ADMIN')") 
    public String adminProfile() { 
        return "Welcome to Admin Profile"; 
    } 
  
    @PostMapping("/generateToken") 
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
    	//System.out.println("vijay");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())); 
        //System.out.println("vijay");
        if (authentication.isAuthenticated()) { 
        	//System.out.println("vijay");
            return jwtService.generateToken(authRequest.getEmail()); 
        } else { 
            throw new UsernameNotFoundException("invalid user request !"); 
        } 
    } 

}
