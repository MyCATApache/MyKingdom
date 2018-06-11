package io.imking.common.beans.dto;

public class UserRoleDTO {
String username;
String authority;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}
@Override
public String toString() {
	return "UserRole [username=" + username + ", authority=" + authority + "]";
}
}
