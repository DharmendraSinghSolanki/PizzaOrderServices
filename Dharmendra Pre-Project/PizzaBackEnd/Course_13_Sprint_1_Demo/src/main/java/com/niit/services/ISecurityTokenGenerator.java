package com.niit.services;

import com.niit.domain.User;

import java.util.Map;

public interface ISecurityTokenGenerator {
    public Map<String,String> tokenGenerator(User user);
    //tokenGenerator method likely takes a User object as input and generates a
    // token in the form of a Map of key-value pairs.
    // The specific details of how the token is generated, what information
}
