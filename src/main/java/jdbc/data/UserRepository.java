package jdbc.data;

import jdbc.entity.User;

public interface UserRepository {

	User save(User user);
  
	User findByUsername(String username);

	void deleteByUsername(String username);
	
}
