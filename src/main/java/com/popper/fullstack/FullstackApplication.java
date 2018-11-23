package com.popper.fullstack;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.popper.fullstack.backend.persistence.domain.backend.Role;
import com.popper.fullstack.backend.service.UserService;
import com.popper.fullstack.enums.PlansEnum;
import com.popper.fullstack.enums.RolesEnum;
import com.popper.fullstack.backend.persistence.domain.backend.*;
import com.popper.fullstack.utils.UsersUtils;

@SpringBootApplication
public class FullstackApplication implements CommandLineRunner{


	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(FullstackApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
	}
	
	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		User user = UsersUtils.createBasicUser();
		HashSet<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, new Role(RolesEnum.BASIC)));
		LOG.debug("Creating user with username {}", user.getUsername());
		userService.createUser(user, PlansEnum.PRO, userRoles);
		LOG.info("User {} created", user.getUsername());
	}
}
