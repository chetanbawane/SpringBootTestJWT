package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Authentication;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyUserDtails;
import com.example.demo.entity.User;
import com.example.demo.repos.UserRepos;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepos userRepos;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user=userRepos.findByUsername(username);
		
		if(user== null) {
			System.out.println("user not found");
				throw new UsernameNotFoundException("not found user");
		}
		return new MyUserDtails(user);
	}
	
	public User saveUser(User user) {
		return userRepos.save(user);
		
	}
	
//	public String verify(User user) {
//		Authentication authentication=
//				(Authentication) authenticationManager.
//		  authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//		
//		if(authentication.isAuthenticated())
//			return "success";
//					
//					return "failed";
//	}
}
