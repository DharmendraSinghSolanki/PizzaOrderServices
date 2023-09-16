package com.niit.Pizza.Order.Details.service;

import com.niit.Pizza.Order.Details.domain.Pizza;
import com.niit.Pizza.Order.Details.domain.User;
import com.niit.Pizza.Order.Details.exception.DataAlreadyAvailable;
import com.niit.Pizza.Order.Details.exception.OrderNotFound;
import com.niit.Pizza.Order.Details.exception.UserNotFound;
import com.niit.Pizza.Order.Details.proxy.UserProxy;
import com.niit.Pizza.Order.Details.repositery.User_Pizza_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class User_Service_Imple implements  User_Service_Interface {


    User_Pizza_Repo userPizzaRepo;
    UserProxy userProxy;
@Autowired
    public User_Service_Imple(User_Pizza_Repo userPizzaRepo, UserProxy userProxy) {
        this.userPizzaRepo = userPizzaRepo;
        this.userProxy = userProxy;
    }

    @Override
    public User register(User user) throws DataAlreadyAvailable {
       if (userPizzaRepo.findById(user.getEmail()).isEmpty())
       {
           userProxy.addAll(user);
         return   userPizzaRepo.save(user);
       }
       throw  new DataAlreadyAvailable();
    }

    @Override
    public User saveOrderToList(Pizza pizza, String email) throws  UserNotFound{
        //check user is PResent pr not
       if (userPizzaRepo.findById(email).isEmpty())
       {
           throw new UserNotFound();
       }

           //User Present
           User result = userPizzaRepo.findById(email).get();
           if (result.getPizzaDetailsList()!=null)
           {
               result.getPizzaDetailsList().add(pizza);
           }
           else
           {
               result.setPizzaDetailsList(new ArrayList<>());
               result.getPizzaDetailsList().add(pizza);
           }
            userPizzaRepo.save(result);
    return  result;
    }
    @Override
    public List<Pizza> getAllOrderFromList(String email) throws UserNotFound {
     if (userPizzaRepo.findById(email).isEmpty())
     {
         throw  new UserNotFound();
     }
     List<Pizza> myPizza= userPizzaRepo.findById(email).get().getPizzaDetailsList();
        return myPizza;
    }
}
