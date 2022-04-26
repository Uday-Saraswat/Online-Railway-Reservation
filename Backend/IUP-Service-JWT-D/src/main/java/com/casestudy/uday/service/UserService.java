package com.casestudy.uday.service;

import java.util.ArrayList;

import com.casestudy.uday.model.UserModel;
import com.casestudy.uday.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
    UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel foundedUser=userrepo.findByusername(username);
		if (foundedUser==null) {
			return null;
		}
		String user=foundedUser.getUsername();
		String pass=foundedUser.getPassword();
		return new User(user, pass,new ArrayList<>());
	}

}
