package com.ascendmoney.riskmanagement;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RiskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskManagementApplication.class, args);
	}
//	@Bean
//	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
//
//		return new InitializingBean() {
//			public void afterPropertiesSet() throws Exception {
//				Group group = identityService.newGroup("business_users");
//				group.setName("Business Group");
//				group.setType("security-role");
//				identityService.saveGroup(group);
//
//				Group group2 = identityService.newGroup("country_users");
//				group.setName("Country Group");
//				group.setType("security-role");
//				identityService.saveGroup(group);
//
//				Group group3 = identityService.newGroup("regional_users");
//				group.setName("Regional Group");
//				group.setType("security-role");
//				identityService.saveGroup(group);
//
//				User admin = identityService.newUser("admin");
//				admin.setPassword("admin");
//				identityService.saveUser(admin);
//
//			}
//		};
//	}
}

