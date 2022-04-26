package com.casestudy.Service;

import com.casestudy.model.User;
import com.casestudy.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class RegistrationService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RegistrationRepository registrationRepository;

    public User saveUser(User user){
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return registrationRepository.save(user);
    }

    public User fetchUserByUsername(String username){
       return  registrationRepository.findByUsername(username);
    }

    public User fetchUserByEmailId(String email){
       return  registrationRepository.findByEmailId(email);
    }

    public User fetchUserByUsernameAndPassword(String username, String password){
        return  registrationRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundedUser=registrationRepository.findByUsername(username);
        if (foundedUser==null) {
            return null;
        }
        String user=foundedUser.getUsername();
        String pass=foundedUser.getPassword();
        return new org.springframework.security.core.userdetails.User(user, pass,new ArrayList<>());
    }


}

