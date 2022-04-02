package academy.lgs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import academy.lgs.domain.User;

@Repository	
public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByUserName(String userName);
}
