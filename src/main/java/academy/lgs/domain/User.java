package academy.lgs.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private Integer userId;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "enabled")
	private int enabled;
	
	public User() {
	}
	
	public User(Integer userId, String userName, String password, String email, int enabled) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
	}

	public User(User user) {
		this.userId = user.userId;
		this.userName = user.userName;
		this.email = user.email;
		this.password = user.password;
		this.enabled = user.enabled;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, enabled, password, userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && enabled == other.enabled
				&& Objects.equals(password, other.password) && userId == other.userId
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", enabled=" + enabled + "]";
	}
}
