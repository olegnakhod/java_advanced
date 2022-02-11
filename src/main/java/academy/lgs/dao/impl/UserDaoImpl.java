package academy.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import academy.lgs.dao.UserDao;
import academy.lgs.domain.User;
import academy.lgs.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {
	private static String READ_ALL = "select * from users";
	private static String CREATE = "insert into users(`first_name`, `last_name`, `email`, `password`, `role`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from users where id =?";
	private static String READ_BY_EMAIL = "select * from users where email =?";
	private static String UPDATE_BY_ID = "update users set first_name = ?, last_name = ? , password = ? , role = ? where id = ?";
	private static String DELETE_BY_ID = "delete from  users  where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public User create(User user) {

		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			user.setUserId(rs.getInt(1));

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return user;

	}

	@Override
	public User read(Integer id) {
		User user = null;

		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer userId = result.getInt("id");
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			String email = result.getString("email");
			String password = result.getString("password");
			String role = result.getString("role");
			user = new User(userId, firstName, lastName, email, password, role);
		} catch (SQLException e) {

			LOGGER.error(e);
		}

		return user;
	}

	@Override
	public User update(User user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return user;

	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

	}

	@Override
	public List<User> readAll() {
		List<User> listOfUser = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer userId = result.getInt("id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				String password = result.getString("password");
				String role = result.getString("role");
				listOfUser.add(new User(userId, firstName, lastName, email, password, role));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return listOfUser;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer userId = result.getInt("id");
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			String password = result.getString("password");
			String role = result.getString("role");
			user = new User(userId, firstName, lastName, email, password, role);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return user;
	}

	@Override
	public boolean toFindUser(String email) {
		boolean userIsFind = false;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			userIsFind = result.next();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return userIsFind;
	}

}
