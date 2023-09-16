package com.niit.Pizza.Order.Details.repositery;


import com.niit.Pizza.Order.Details.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Pizza_Repo extends MongoRepository<User, String> {
   public User findByEmail();
}
