package Service;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Model.User;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String username, String password) {
	    return this.get(username, password);
	}
	@Override
	public User get(String username,String password) {
		return userDao.get(username,password);
	}
	
	
	
	@Override
	public boolean register(String username, String password, String email, String
	fullname, String phone ) {
	if (userDao.checkExistUsername(username)) {
	return false;
	}
	long millis=System.currentTimeMillis();
	java.sql.Date date=new java.sql.Date(millis);
	userDao.insert(new User(email, username, fullname,password,
	null,5,phone,date));
	return true;
	}
	@Override
	public User findByUsernameAndEmail(String username, String email) {
	    return userDao.findByUsernameAndEmail(username, email);
	}

	@Override
	public void updatePassword(String username, String newPassword) {
	    userDao.updatePassword(username, newPassword);
	}
	
	
	
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
		}
		public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
		}
		@Override
		public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
		}
		@Override
		public void insert(User user) {
		userDao.insert(user);
		}
	
	
	
}
