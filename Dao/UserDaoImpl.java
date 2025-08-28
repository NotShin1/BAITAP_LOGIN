package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.User;
import util.DBConnection;

public class UserDaoImpl implements UserDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public User get(String username,String password) {
	String sql = "SELECT * FROM [User] WHERE username = ? AND password = ?";
	try {
	conn = new DBConnection().getConnection();
	ps = conn.prepareStatement(sql);
	ps.setString(1, username);
	ps.setString(2, password);
	rs = ps.executeQuery();
	while (rs.next()) {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("username"));
		user.setFullName(rs.getString("fullname"));
		user.setPassWord(rs.getString("password"));
		user.setAvatar(rs.getString("avatar"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreatedDate(rs.getDate("createdDate"));
	return user; }
	} catch (Exception e) {e.printStackTrace(); }
	return null;
	}
}
