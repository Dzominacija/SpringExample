package config;

import org.springframework.context.annotation.Bean;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class MyBeanConfig {

	@Bean(name = "userDao")
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}
}
