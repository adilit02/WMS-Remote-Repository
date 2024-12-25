package ait.com.service;

import java.util.List;
import java.util.Optional;

import ait.com.entity.User;

public interface UserService {

	public List<User> getAllUser();

	public User createdUser(User user);

	
	public Optional<User> getUserById(Integer Id);

	public User updateUser(User user);

	public void deleteUser(Integer Id);

	public List<User> getUserByRoll(String Roll);

}
