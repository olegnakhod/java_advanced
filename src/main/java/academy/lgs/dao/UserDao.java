package academy.lgs.dao;

import academy.lgs.domain.User;
import academy.lgs.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User>{
	User getUserByEmail(String email);
	boolean toFindUser(String email);

}
