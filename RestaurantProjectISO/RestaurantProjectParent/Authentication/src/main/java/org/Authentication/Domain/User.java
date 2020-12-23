package org.Authentication.Domain;

/**
 * The Class User.
 */
public class User {

	/** The name. */
	private String name;
	
	/** The password. */
	private String password;
	
	/** The type. */
	private String type;

	/** The user manager. */
	private UsersManager userManager;

	/**
	 * Instantiates a new user.
	 */
	public User() {
		this.userManager = new UsersManager();
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param name the name
	 * @param password the password
	 * @param type the type
	 * @throws Exception the exception
	 */
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

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 * @throws Exception the exception
	 */
	public void setName(String name) throws Exception {
		if (name.length() < 1) {
			throw new Exception("User cannot be empty");
		}
		this.name = name;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 * @throws Exception the exception
	 */
	public void setPassword(String password) throws Exception {
		if (password.length() < 1) {
			throw new Exception("Password cannot be empty");
		}
		this.password = password;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 * @throws Exception the exception
	 */
	public void setType(String type) throws Exception {
		if (type.length() < 1) {
			throw new Exception("Type cannot be empty");
		}
		this.type = type;
	}

	/**
	 * Gets the user manager.
	 *
	 * @return the user manager
	 */
	public UsersManager getUserManager() {
		return userManager;
	}

	/**
	 * Delete.
	 *
	 * @return true, if successful
	 */
	public boolean delete() {
		return userManager.delete(this);
	}

	/**
	 * Authenticate.
	 *
	 * @return true, if successful
	 */
	public boolean authenticate() {
		return userManager.login(this);
	}

	/**
	 * Read all.
	 *
	 * @return true, if successful
	 */
	public boolean readAll() {
		return userManager.readAll();
	}

	/**
	 * Update.
	 *
	 * @return true, if successful
	 */
	public boolean update() {
		return userManager.update(this);
	}

	/**
	 * Insert.
	 *
	 * @return true, if successful
	 */
	public boolean insert() {
		return userManager.insert(this);
	}

}