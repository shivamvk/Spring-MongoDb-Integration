package io.shivamvk.springmongo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.shivamvk.springmongo.error.Error;

@RestController
public class Controller {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Autowired
	private UserService service;
	
	@PostMapping(value="/login")
	public Object Login(@RequestParam String email, @RequestParam String password) {
		User user = service.findByEmail(email);
		if(user == null) {
			Error error = new Error(500, "Account does not exist");
			return error;
		} else if(!user.getPassword().equals(password)) {
			Error error = new Error(500, "Invalid email or password");
			return error;
		} else {
			return user;
		}
	}
	
	@PostMapping(value="/signup")
	public Object Signup(@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String phone) {
		List<User> list = service.getAllUsers();
		User user = new User(name, email, password, phone);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
	    if(!matcher.find()) {
	    	Error error = new Error(500, "Email address not valid");
			return error;
	    }
		if(password.length() < 6) {
			Error error = new Error(500, "Password length can't be less than 6");
			return error;
		} else if(phone.length() != 10) {
			Error error = new Error(500, "Phone number not valid");
			return error;
		} else if(checkIfAlreadyExists(list, user)) {
			Error error = new Error(500, "User already exists with this email");
			return error;
		} else {
			User user1 = new User(name,email,password,phone);
			service.insert(user1);
			return user1;
		}
	}
	
	@PostMapping(value="/users/{userid}/address")
	public Object saveAddress(@PathVariable String userid,
			@RequestParam String address,
			@RequestParam String city,
			@RequestParam String state,
			@RequestParam String country) {
		User user = service.findByEmail(userid);
		if(user == null) {
			Error error = new Error(500, "No user exists with this email");
			return error;
		} else {
			user.setAddress(new Address(address, city, state, country));
			service.insert(user);
			return user;
		}
	}

	@GetMapping(value="/ListUsers")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	public boolean checkIfAlreadyExists(List<User> list, User user) {
		boolean bool = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getEmail().equals(user.getEmail())) {
				bool = true;
			}
		}
		return bool;
	}
}
