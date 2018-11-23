package com.popper.fullstack.test.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.popper.fullstack.backend.persistence.domain.backend.*;
import com.popper.fullstack.backend.service.UserService;
import com.popper.fullstack.enums.PlansEnum;
import com.popper.fullstack.enums.RolesEnum;
import com.popper.fullstack.utils.UsersUtils;


public class UserServiceIntegrationTest {

	@Autowired
    private UserService userService;

    @Test
    public void testCreateNewUser() throws Exception {

        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UsersUtils.createBasicUser();
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

        User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

    }
}
