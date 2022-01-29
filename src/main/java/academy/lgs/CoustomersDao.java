package academy.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class CoustomersDao {
	
	private static String READ_ALL = "select * from coustomers";
	private static String CREATE = "insert into coustomers(`firstName`, `lastName`) values (?,?)";
	private static String READ_BY_ID = "select * from coustomers where id =?";
	private static String UPDATE_BY_ID = "update coustomers set firstName=?, lastName = ? where id = ?";
	private static String DELETE_BY_ID = "delete from coustomers where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public CoustomersDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Coustomers coustomer) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, coustomer.getFirstName());
		preparedStatement.setString(2, coustomer.getLastName());
		preparedStatement.executeUpdate();
	}

	public Coustomers read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return CoustomersMapper.map(result);
	}

	public void update(Coustomers coustomer) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, coustomer.getFirstName());
		preparedStatement.setString(2, coustomer.getLastName());
		preparedStatement.setInt(3, coustomer.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Coustomers> readAll() throws SQLException {
		List<Coustomers> listOfEmployee = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfEmployee.add(CoustomersMapper.map(result));
		}
		return listOfEmployee;
	}

}
