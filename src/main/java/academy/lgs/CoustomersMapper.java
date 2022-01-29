package academy.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoustomersMapper {
	
	public static Coustomers map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String firstName = result.getString("firstName");
		String lastName = result.getString("lastName");
		
		return new  Coustomers(id,firstName,lastName);
	}
}
