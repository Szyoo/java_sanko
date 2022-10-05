package jp.co.kikaku.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "seq_users_gen")
	@SequenceGenerator(name = "seq_users_gen", sequenceName = "seq_users", 
	allocationSize = 1)
	private Integer userId;
	
	@Column
	private String userName;
	
	@Column
	private String password;
	
	@Column
	private Integer authority;
	
	@Column
	private Date registrationDate;

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

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

}
