//package ait.com.service;
package ait.com.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.com.entity.User;
import ait.com.repo.UserRepository;
import ait.com.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	public UserRepository userRepo;

	@Override
	public List<User> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public User createdUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public Optional<User> getUserById(Integer Id) {

		return userRepo.findById(Id);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);

	}

	@Override
	public void deleteUser(Integer Id) {

		userRepo.deleteById(Id);
	}

	@Override
	public List<User> getUserByRoll(String Roll) {

		return  userRepo.findByroll(Roll); 
	}

}
