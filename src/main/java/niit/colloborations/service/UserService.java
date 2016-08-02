package niit.colloborations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import niit.colloborations.dao.UserDAO;
import niit.colloborations.model.User;

@Service
public class UserService {
	@Autowired
	UserDAO	userDAO;
	
	public void insertUser(User user)
	{
		System.out.println("insert user is called");
		userDAO.insertUser(user);
		
	}
	
	 public boolean login(String user,String pass)
	 {
		 return userDAO.login(user, pass);
		 
	 }
	public void saveOrUpdate(User user)
	{
		userDAO.saveOrUpdate(user);	
	}
	    

}
