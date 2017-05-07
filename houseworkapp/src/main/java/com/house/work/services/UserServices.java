package com.house.work.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.house.work.entity.Role;
import com.house.work.entity.User;
import com.house.work.repository.RoleRepository;
import com.house.work.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
	
	public void saveUser(User user) {
		System.out.println("iniin2");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = null;
        if(user.getRegisterAsCustomer() == 1) {
        	userRole = roleRepository.findByRole("CUSTOMER");
        } else if(user.getRegisterAsLabour() == 1) {
        	userRole = roleRepository.findByRole("LABOUR");
        } else {
        	userRole = roleRepository.findByRole("ADMIN");
        }
        
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
}
