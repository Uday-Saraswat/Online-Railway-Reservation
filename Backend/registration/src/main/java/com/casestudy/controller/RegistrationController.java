package com.casestudy.controller;

import com.casestudy.Service.RegistrationService;
import com.casestudy.model.JwtRequest;
import com.casestudy.model.JwtResponse;
import com.casestudy.model.User;
import com.casestudy.repository.RegistrationRepository;
import com.casestudy.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

    @Autowired
    AuthenticationManager authenticates;

    @Autowired
    JwtUtils jwtutil;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/registeruser")
    @CrossOrigin(origins = "http://localhost:3000")
    public  User registerUser(@RequestBody User user) throws Exception {
        String tempUsername = user.getUsername();
        if(tempUsername != null && !"".equals(tempUsername)){
           User userobj =  registrationService.fetchUserByUsername(tempUsername);
           if(userobj != null){
               throw new Exception("User with "+ tempUsername + " is already exist");
           }
        }
        User userObj = null;
        userObj = registrationService.saveUser(user);
        return userObj;
    }


    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")

    private ResponseEntity<?> authenticateUser(@RequestBody JwtRequest jwtreq){
        String username=jwtreq.getUsername();
        String password= jwtreq.getPassword();
        try {
            authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        }
        catch(Exception e) {
            return ResponseEntity.ok(new JwtResponse(" Invalid Credentials..!"));
        }

        UserDetails userdetails= registrationService.loadUserByUsername(username);

        String jwt = jwtutil.generateToken(userdetails);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

//    @PostMapping("/login")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public User loginUser(@RequestBody User user) throws Exception {
//        String tempUsername = user.getUsername();
//        String tempPassword = user.getPassword();
//        User userObj = null;
//        if(tempUsername != null && tempPassword != null){
//            userObj= registrationService.fetchUserByUsernameAndPassword(tempUsername,tempPassword);
//        }
//        if(userObj ==null){
//            throw new Exception("Bad credentials");
//        }
//
//        return userObj;
//    }



}
