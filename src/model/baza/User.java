package model.baza;

import java.io.Serializable;

public abstract class User implements Serializable {
	private int ID;
	public static int k=0;
	private String username;
	private String password;
	protected Tipi tipi;
	public User(String user,String pass){
		ID=k++;
		username=user;
		password=pass;
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
	public Tipi getTipi() {
		return tipi;
	}
	public abstract void setTipi(Tipi tipi);
	
}
