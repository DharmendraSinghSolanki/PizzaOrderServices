package com.niit.services;

import com.niit.domain.User;

import java.util.List;

public interface InterService {
    public User addData(User user);
    public List<User> getAllData();
    public  String DeleteData(String email);
    public  User Update(User user);
    public  List <User> getAllUserByFirstName(String firstName);
    public User loginCheck(String email, String password);
}
//The code you've provided defines a Java interface named InterService.
// This interface appears to define a contract for a service layer that deals with user-related
// operations in a Java or Spring-based application. Let's break down the methods declared in this interface: