package com.popper.fullstack.test.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.popper.fullstack.FullstackApplication;
import com.popper.fullstack.backend.persistence.repositories.RoleRepository;
import com.popper.fullstack.backend.persistence.repositories.UserRepository;
import com.popper.fullstack.backend.persistence.domain.backend.Plan;
import com.popper.fullstack.backend.persistence.repositories.PlanRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FullstackApplication.class)
public class RepositoryIntegrationTest {

	@Autowired
	private PlanRepository planRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	
	private static final int BASIC_PLAN_ID = 1;
	private static final int BASIC_ROLE_ID = 1;
	
	@Before
	public void init() {
		Assert.assertNotNull(planRepository);
		Assert.assertNotNull(roleRepository);
		Assert.assertNotNull(userRepository);
	}
	
	@Test
	public void testCreateNewPlan() throws Exception{
		Plan basicPlan = createBasicPlan();
		planRepository.save(basicPlan);
		Plan retrievePlan = planRepository.findOne(BASIC_PLAN_ID);
		Assert.assertNotNull(retrievePlan);
	}
	private Plan createBasicPlan() {
		Plan plan = new Plan();
		plan.setId(BASIC_PLAN_ID);
		plan.setName("name");
		return plan;
	}
}
