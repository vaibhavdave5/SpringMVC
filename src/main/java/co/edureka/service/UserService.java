package co.edureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edureka.dao.UsersDAO;
import co.edureka.model.Users;


@Service("userService")
public class UserService {

	UsersDAO userDao;

	@Autowired
	public void setUserDao(UsersDAO userDao) {
		this.userDao = userDao;
	}

	public void saveOrUpdate(Users user) {
		userDao.insertUser(user);
	}
	
	public Users getUser(String email, String password) {
		return userDao.findUser(email, password);
	}

	
}
