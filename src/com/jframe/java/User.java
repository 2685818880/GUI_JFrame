package com.jframe.java;

public class User {
private String name="admin";
private String password="admin";
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String name, String password) {
	super();
	this.name = name;
	this.password = password;
}

}