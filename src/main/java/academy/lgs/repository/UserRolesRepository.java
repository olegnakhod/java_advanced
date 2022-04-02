 package academy.lgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import academy.lgs.domain.UserRole;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRole,Integer>{
	@Query("select a.role from UserRole a, User b where b.userName=?1 and a.userid=b.userId")
	public List<String> findRoleByUserName(String username);
}
