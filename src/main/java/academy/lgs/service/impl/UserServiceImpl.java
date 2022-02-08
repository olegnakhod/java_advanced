package academy.lgs.service.impl;

import java.util.List;

import academy.lgs.dao.UserDao;
import academy.lgs.dao.impl.UserDaoImpl;
import academy.lgs.domain.User;
import academy.lgs.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public User create(User t) {
		return userDao.create(t);
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User t) {
		return userDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
		
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

}
