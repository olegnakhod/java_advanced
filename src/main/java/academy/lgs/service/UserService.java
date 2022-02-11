package academy.lgs.service;

import academy.lgs.domain.User;
import academy.lgs.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User>{
	User getUserByEmail(String email);
	boolean toFindUser(String email);
}
