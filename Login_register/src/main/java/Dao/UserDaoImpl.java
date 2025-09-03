package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	@Override
	public void insert(User user) {
	String sql = "INSERT INTO [User](email, username, fullname, password, avatar, roleid,phone,createddate) VALUES (?,?,?,?,?,?,?,?)";
	try {
	conn = new DBConnection().getConnection();
	ps = conn.prepareStatement(sql);
	ps.setString(1, user.getEmail());
	ps.setString(2, user.getUserName());
	ps.setString(3, user.getFullName());
	ps.setString(4, user.getPassWord());
	ps.setString(5, user.getAvatar());
	ps.setInt(6,user.getRoleid());
	ps.setString(7,user.getPhone());
	ps.setDate(8, user.getCreatedDate());
	ps.executeUpdate();
	} catch (Exception e) {e.printStackTrace();}
	}
	
	
	@Override
	public boolean checkExistEmail(String email) {
	boolean duplicate = false;
	String query = "select * from [User] where email = ?";
	try {
	conn = new DBConnection().getConnection();
	ps = conn.prepareStatement(query);
	ps.setString(1, email);
	rs = ps.executeQuery();
	if (rs.next()) {
	duplicate = true;
	}
	ps.close();
	conn.close();
	} catch (Exception ex) {}
	return duplicate;
	}
	
	
	@Override
	public boolean checkExistUsername(String username) {
	boolean duplicate = false;
	String query = "select * from [User] where username = ?";
	try {
	conn = new DBConnection().getConnection();
	ps = conn.prepareStatement(query);
	ps.setString(1, username);
	rs = ps.executeQuery();
	if (rs.next()) {
	duplicate = true;
	}
	ps.close();
	conn.close();
	} catch (Exception ex) {}
	return duplicate;
	}
	
	@Override
    public boolean checkExistPhone(String phone) {
        String sql = "SELECT COUNT(*) FROM User WHERE phone = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, phone);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	@Override
	public User findByUsernameAndEmail(String username, String email) {
	    String sql = "SELECT * FROM [User] WHERE username = ? AND email = ?";
	    try {
	        conn = new DBConnection().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        ps.setString(2, email);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            User u = new User();
	            u.setUserName(rs.getString("username"));
	            u.setEmail(rs.getString("email"));
	            u.setFullName(rs.getString("fullname"));
	            u.setPassWord(rs.getString("password"));
	            u.setRoleid(rs.getInt("roleid"));
	            return u;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public void updatePassword(String username, String newPassword) {
	    String sql = "UPDATE [User] SET password=? WHERE username=?";
	    try {
	        conn = new DBConnection().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, newPassword);
	        ps.setString(2, username);
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
}
