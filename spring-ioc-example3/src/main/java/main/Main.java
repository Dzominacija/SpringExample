package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.MyBeanConfig;
import dao.UserDao;
import domain.User;

public class Main {

	public static void main(String[] args) {

		
		User user1 = new User("Nikola1", "12345");
		User user2 = new User("Nikola2", "12345");
		User user3 = new User("Nikola3", "12345");
		UserContainer.saveUser(user1);
		UserContainer.saveUser(user2);
		UserContainer.saveUser(user3);
		UserContainer.printUsers();
		UserContainer.classPathXmlConfiguration();
	}

	public static class UserContainer {

		static BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);

		private static void saveUser(User user) {

			UserDao userDao = container.getBean("userDao", UserDao.class);
			userDao.save(user);
		}

		private static void printUsers() {

			UserDao userDao = container.getBean("userDao", UserDao.class);
			userDao.printAll();
		}

		private static void classPathXmlConfiguration() {
			BeanFactory container = new ClassPathXmlApplicationContext("classpath:application-context.xml");
			UserDao userDao = (UserDao) container.getBean("dao");
			userDao.save(new User("Nikola4", "12345"));
			userDao.printAll();
		}
	}
}
