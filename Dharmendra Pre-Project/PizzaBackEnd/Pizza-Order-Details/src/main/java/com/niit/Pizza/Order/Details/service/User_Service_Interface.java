package com.niit.Pizza.Order.Details.service;


import com.niit.Pizza.Order.Details.domain.Pizza;
import com.niit.Pizza.Order.Details.domain.User;
import com.niit.Pizza.Order.Details.exception.DataAlreadyAvailable;
import com.niit.Pizza.Order.Details.exception.UserNotFound;

import java.util.List;

public interface User_Service_Interface {
    public User register(User user) throws DataAlreadyAvailable;
    public User saveOrderToList(Pizza pizza, String email) throws  UserNotFound;
     public List<Pizza> getAllOrderFromList(String email) throws UserNotFound ;

}
