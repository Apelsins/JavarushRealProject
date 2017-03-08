
package com.apelsin.crud.dao;

import com.apelsin.crud.dao.UserDAO;
import com.apelsin.crud.entity.User;
import com.apelsin.crud.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Repository
public class UserDAOImpl implements UserDAO {
    
	public UserDAOImpl() {
    	System.out.println("EmployeeDAOImpl");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createUser(User user) {
        return (Long) hibernateUtil.create(user);
    }
    
    @Override
    public User updateUser(User user) {
        return hibernateUtil.update(user);
    }
    
    @Override
    public void deleteUser(long id) {
        User User = new User();
        User.setId(id);
        hibernateUtil.delete(User);
    }
    
    @Override
    public List<User> getAllUsers() {
        return hibernateUtil.fetchAll(User.class);
    }
    
    @Override
    public User getUser(long id) {
        return hibernateUtil.fetchById(id, User.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers(String userName) {

		String query = "SELECT u.* FROM Users u WHERE u.name like '%"+ userName +"%'";
		List<Object[]> userObjects = hibernateUtil.fetchAll(query);
		List<User> users = new ArrayList<User>();
		for(Object[] userObject: userObjects) {
            User user = new User();
			long id = ((BigInteger) userObject[0]).longValue();
            String name = (String) userObject[4];
            int age = (int) userObject[1];
			boolean isAdmin = (boolean) userObject[3];
           // Timestamp tm = (Timestamp) userObject[4];
            Date createdDate = (Date) userObject[2]; //new Date(tm.getTime());
			user.setId(id);
			user.setName(name);
			user.setAge(age);
			user.setAdmin(isAdmin);
			user.setCreatedDate(createdDate);

            users.add(user);
		}
		System.out.println(users);
		return users;
	}
}