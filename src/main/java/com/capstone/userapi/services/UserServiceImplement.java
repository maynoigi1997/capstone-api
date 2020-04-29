/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.userapi.services;

import com.capstone.userapi.dtos.Users;
import com.capstone.userapi.repositories.UsersRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author hoang
 */
@Service(value = "userService")
public class UserServiceImplement implements UserDetailsService{
    @Autowired
    UsersRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        	Users user = userRepository.findByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
	}

//	private Set<SimpleGrantedAuthority> getAuthority(Users user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//		user.getListRoles().forEach(role -> {			
//            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//		});
//		return authorities;
//		
//	}
private Set<SimpleGrantedAuthority> getAuthority(Users user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		return authorities;
		
	}
	
    
}
