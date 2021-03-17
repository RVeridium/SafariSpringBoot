package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.SafariUser;
import com.example.demo.domain.repos.SafUserRepo;



@Service
public class UserDetailServiceImp implements UserDetailsService {
	private final SafUserRepo urepo; 
	
	@Autowired
	public UserDetailServiceImp(SafUserRepo repository) {
		this.urepo = repository;
	}   
	
	 @Override
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
	    	SafariUser curruser = urepo.findByUsername(username);
	        UserDetails user = new User(username, curruser.getPwHashed(), 
	        		AuthorityUtils.createAuthorityList(curruser.getRole()));
	        return user;
	    }
	
}
