package io.shivamvk.springmongo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
	
	@Autowired
	private Repository repository;
	
	public void insert(User user) {
		repository.save(user);
	}
	
	public User getUser(String email) {
		return repository.findById(email).get();
	}
	
	public List<User> getAllUsers() {
		return (List<User>)repository.findAll();
	}
	
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
}
