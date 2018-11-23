package com.popper.fullstack.backend.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.popper.fullstack.backend.persistence.repositories.*;
import com.popper.fullstack.backend.persistence.domain.backend.*;
import com.popper.fullstack.enums.*;

@Service
@Transactional(readOnly = true)
public class UserService {
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PlanRepository planRepository; 
	
	@Transactional
	public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles) {
		
		Plan plan = new Plan(plansEnum);
		if(!planRepository.exists(plansEnum.getId())) {
			plan = planRepository.save(plan);
		}
		user.setPlan(plan);
		for(UserRole ur: userRoles) {
			roleRepository.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRoles);
		user = userRepository.save(user);
		return user;
	}
}
