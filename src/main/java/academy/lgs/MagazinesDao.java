package academy.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazinesDao {
	
	private static String READ_ALL = "select * from magazines";
	private static String CREATE = "insert into magazines(`name`, `price`) values (?,?)";
	private static String READ_BY_ID = "select * from magazines where id =?";
	private static String UPDATE_BY_ID = "update magazines set name=?, price=? where id = ?";
	private static String DELETE_BY_ID = "delete from magazines where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public MagazinesDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Magazines magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, magazine.getName());
		preparedStatement.setInt(2, magazine.getPrice());
		preparedStatement.executeUpdate();
	}

	public Magazines read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return MagazinesMapper.map(result);
	}

	public void update(Magazines magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, magazine.getName());
		preparedStatement.setInt(2, magazine.getPrice());
		preparedStatement.setInt(3, magazine.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Magazines> readAll() throws SQLException {
		List<Magazines> listOfMagazines = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfMagazines.add(MagazinesMapper.map(result));
		}
		return listOfMagazines;
	}

}
