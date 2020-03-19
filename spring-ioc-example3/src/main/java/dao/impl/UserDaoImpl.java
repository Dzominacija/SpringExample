package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import domain.User;

public class UserDaoImpl implements UserDao{

	private List<User> users;

	public UserDaoImpl() {
		this.users = new ArrayList<User>();
	}
	public void save(User user) {
		users.add(user);
		//this.printAll();
	}
	public void printAll() {
		for (User user : this.users) {
			System.out.println(user);
		}
		
	}
	
	
}
