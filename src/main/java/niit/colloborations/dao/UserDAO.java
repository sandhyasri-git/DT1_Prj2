package niit.colloborations.dao;

import java.util.List;

import niit.colloborations.model.User;

public interface UserDAO {
	public List<User> list();

	public void saveOrUpdate(User user);
	public User gerUserById(int id);
	public User getUserByName(String name);
		
	


}
