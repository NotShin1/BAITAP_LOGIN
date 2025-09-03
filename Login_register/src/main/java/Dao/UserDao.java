package Dao;

import Model.User;

public interface UserDao {
    User get(String username,String password);
    void insert(User user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	
	User findByUsernameAndEmail(String username, String email);
	void updatePassword(String username, String newPassword);

}
