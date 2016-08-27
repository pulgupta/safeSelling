package com.org.safeSelling.dao;

import com.org.safeSelling.dto.User;

public interface UserRepository {

	public void save(User user);
	public User findByUsername(String username);
	public void update(User user);

}
