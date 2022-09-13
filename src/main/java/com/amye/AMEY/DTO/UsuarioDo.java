package com.amye.AMEY.DTO;

public class UsuarioDo {
	private int id;
	private String user;
	
	public UsuarioDo(int id, String user) {
		super();
		this.id = id;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
}
