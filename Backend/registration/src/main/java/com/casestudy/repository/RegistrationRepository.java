package com.casestudy.repository;

import com.casestudy.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistrationRepository extends MongoRepository<User, Integer> {

    public User findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);


    public User findByEmailId(String email);

}
