package com.broadway.studentproject.service;

import java.util.List;

import com.broadway.studentproject.dao.UserDao;
import com.broadway.studentproject.dao.UserDaoImpl;
import com.broadway.studentproject.dto.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public void saveUserInfo(User user) {
		// TODO Auto-generated method stub
		userDao.saveUserInfo(user);
	}

	@Override
	public void updateUserInfo(User user) {
		// TODO Auto-generated method stub
		userDao.updateUserInfo(user);
	}

	@Override
	public void deleteUserInfo(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUserInfo(id);
	}

	@Override
	public List<User> getAllUserInfo() {
		// TODO Auto-generated method stub

		return userDao.getAllUserInfo();
	}

	@Override
	public User getUserInfoById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserInfoById(id);
	}

	@Override
	public String getImageUrl(int id) {
		// TODO Auto-generated method stub
		return userDao.getImageUrl(id);
	}

	@Override
	public int checkUser(String userName, String password) {
		// TODO Auto-generated method stub
		return userDao.checkUser(userName, password);
	}

	@Override
	public User checkMail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkMail(email);
	}

}
