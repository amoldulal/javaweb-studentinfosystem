package com.broadway.studentproject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.broadway.studentproject.dto.User;
import com.broadway.studentproject.util.DbUtil;

public class UserDaoImpl implements UserDao{
	private PreparedStatement ps = null;

	@Override
	public void saveUserInfo(User user) {
		String sql = "insert into users(first_name, last_name, email, dob, username, password, gender, image_url)values(?,?,?,?,?,?,?,?)";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setDate(4, new java.sql.Date(user.getDob().getTime()));
			ps.setString(5, user.getUserName());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getGender());
			ps.setString(8, user.getImageUrl());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserInfo(User user) {
		String sql = "update users set first_name=?, last_name=?, email=?, dob=?,username=?,password=?, gender=?,image_url=? where user_id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setDate(4, new java.sql.Date(user.getDob().getTime()));
			ps.setString(5, user.getUserName());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getGender());
			ps.setString(8, user.getImageUrl());
			ps.setInt(9, user.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUserInfo(int id) {
		String sql = "delete from users where user_id = ?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<>();
		String sql = "select * from users";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setDob(rs.getDate("dob"));
				userList.add(user);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserInfoById(int id) {
		User user = new User();
		String sql = "select * from users where user_id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setDob(rs.getDate("dob"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String getImageUrl(int id) {
		String sql= "select image_url from users where user_id=?";
		String imageUrl="";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				imageUrl = rs.getString("image_url");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageUrl;
	}

	@Override
	public int checkUser(String userName, String password) {
		String sql = "select * from users where username=? and password=?";
		int isUser=0;
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				isUser = rs.getInt("user_id");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUser;
	}

	@Override
	public User checkMail(String email) {
		return null;
	}

	}