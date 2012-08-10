package com.example.bbstore.dom;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class User extends BaseEntity{
	
	public enum Role
	{
		USER("user"),MANAGER("manager"),ADMIN("admin");	
		
		private String name;
		Role(String name) {
			this.setName(name);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	private String userName;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	} 
}
