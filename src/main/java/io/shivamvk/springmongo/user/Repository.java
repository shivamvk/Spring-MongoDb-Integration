package io.shivamvk.springmongo.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<User, String>{
	public User findByEmail(String email);
}
