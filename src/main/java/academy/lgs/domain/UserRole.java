package academy.lgs.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id")
	private Integer userroleid;

	@Column(name = "userid")
	private Integer userid;

	@Column(name = "role")
	private String role;

	public UserRole() {
	}

	public UserRole(Integer userRoleId, Integer userId, String role) {
		this.userroleid = userRoleId;
		this.userid = userId;
		this.role = role;
	}

	public Integer getUserRoleId() {
		return userroleid;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userroleid = userRoleId;
	}

	public Integer getUserId() {
		return userid;
	}

	public void setUserId(Integer userId) {
		this.userid = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(role, userid, userroleid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return Objects.equals(role, other.role) && Objects.equals(userid, other.userid)
				&& Objects.equals(userroleid, other.userroleid);
	}

	@Override
	public String toString() {
		return "UserRole [userroleid=" + userroleid + ", userid=" + userid + ", role=" + role + "]";
	}


}
