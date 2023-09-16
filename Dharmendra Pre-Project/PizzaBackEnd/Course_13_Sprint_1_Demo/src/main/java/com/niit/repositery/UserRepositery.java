package com.niit.repositery;

import com.niit.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositery extends JpaRepository<User, String> {

    public List<User> findByfirstName(String firstName);
}
