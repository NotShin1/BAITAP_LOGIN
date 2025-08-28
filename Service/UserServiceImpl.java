package Service;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Model.User;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String username, String password) {
			User user = this.get(username,password);
	if (user != null && password.equals(user.getPassWord())) {
			return user;
	}
	return null;
	}
	@Override
	public User get(String username,String password) {
		return userDao.get(username,password);
	}
}
