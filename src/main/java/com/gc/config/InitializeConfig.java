package com.gc.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.gc.entity.User;
import com.gc.service.UserService;

@Configuration
public class InitializeConfig implements InitializingBean {

	@Autowired
	private UserService userService;

	@Autowired
	private Environment env;

	/*@Bean
	public void initSupperUser() {
		User user = new User();
		long i = 4;
		user.setId(i);
		user.setPseudo(env.getProperty("defaultUserName"));
		user.setMdp(env.getProperty("defaultUserPassword"));
		user.setRole(env.getProperty("defaultUserRole"));
		user.setBlocked(false);
		userService.update(user, i);
	}*/

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

}
