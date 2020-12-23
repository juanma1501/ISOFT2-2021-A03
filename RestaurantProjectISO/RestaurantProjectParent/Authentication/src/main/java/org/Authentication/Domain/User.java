package org.Authentication.Domain;

public class User {

	private String name;
	private String password;
	private String type;

	private UsersManager userManager;

	public User() {
		this.userManager = new UsersManager();
	}

	public User(String name, String password, String type) throws Exception {
		if (name.length() < 1) {
			throw new Exception("The name cannot be empty");
		}
		if (password.length() < 1) {
			throw new Exception("Password cannot be empty");
		}
		if (type.length() < 1) {
			throw new Exception("Type cannot be empty");
		}
		this.userManager = new UsersManager();
		setName(name);
		setPassword(password);
		setType(type);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if (name.length() < 1) {
			throw new Exception("User cannot be empty");
		}
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws Exception {
		if (password.length() < 1) {
			throw new Exception("Password cannot be empty");
		}
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) throws Exception {
		if (type.length() < 1) {
			throw new Exception("Type cannot be empty");
		}
		this.type = type;
	}

	public UsersManager getUserManager() {
		return userManager;
	}

	public boolean delete() {
		return userManager.delete(this);
	}

	public boolean authenticate() {
		return userManager.login(this);
	}

	public boolean readAll() {
		return userManager.readAll();
	}

	public boolean update() {
		return userManager.update(this);
	}

	public boolean insert() {
		return userManager.insert(this);
	}

}