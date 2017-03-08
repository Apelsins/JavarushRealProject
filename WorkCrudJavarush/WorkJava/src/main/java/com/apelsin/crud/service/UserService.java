
package com.apelsin.crud.service;
import com.apelsin.crud.entity.User;

import java.util.List;


public interface UserService {
	long createUser(User user);
    User updateUser(User user);
    void deleteUser(long id);
    List<User> getAllUsers();
    User getUser(long id);
	List<User> getAllUsers(String UserName);
}
