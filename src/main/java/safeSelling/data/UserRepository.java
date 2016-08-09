package safeSelling.data;

import safeSelling.User;

public interface UserRepository {

	public void save(User user);
	public User findByUsername(String username);
	public void update(User user);

}
