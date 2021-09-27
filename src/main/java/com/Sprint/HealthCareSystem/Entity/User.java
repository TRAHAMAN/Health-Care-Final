package com.Sprint.HealthCareSystem.Entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_ID")
	private int uid;
	@Column(name = "User_Name", nullable = false, length = 10)
	private String username;
	@Column(name = "User_Password", nullable = false, length = 8)
	private String password;
	@Column(name = "User_Role", nullable = false, length = 10)
	private String role;
	public User(String username, String password, String role) {
		this.password = password;
		this.username = username;
		this.role = role;

	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column(columnDefinition = "boolean default false")
    private boolean isLoggedIn;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
	
}
