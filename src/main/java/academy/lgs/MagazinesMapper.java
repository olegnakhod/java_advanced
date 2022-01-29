package academy.lgs;

import java.sql.SQLException;
import java.sql.ResultSet;

public class MagazinesMapper {
	
	public static Magazines map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		int price = result.getInt("price");
		
		return new Magazines(id,name,price);
	}
	
}
