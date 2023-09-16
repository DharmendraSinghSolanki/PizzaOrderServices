package com.niit.Pizza.Order.Details.controller;

import com.niit.Pizza.Order.Details.domain.Pizza;
import com.niit.Pizza.Order.Details.domain.User;
import com.niit.Pizza.Order.Details.exception.DataAlreadyAvailable;
import com.niit.Pizza.Order.Details.exception.UserNotFound;
import com.niit.Pizza.Order.Details.repositery.User_Pizza_Repo;
import com.niit.Pizza.Order.Details.service.User_Service_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user/pizza")
public class UserController {
    User_Service_Interface userServiceInterface;
    User_Pizza_Repo userPizzaRepo;

    @Autowired
    public UserController(User_Service_Interface userServiceInterface, User_Pizza_Repo userPizzaRepo) {
        this.userServiceInterface = userServiceInterface;
        this.userPizzaRepo = userPizzaRepo;
    }

    @PostMapping("/add")
    public ResponseEntity<?> registerUserDetails(@RequestBody User user)
    {
        try
        {
            User user1=userServiceInterface.register(user);
            return  new ResponseEntity<>(user1, HttpStatus.CREATED);
        } catch (DataAlreadyAvailable e) {
            throw new RuntimeException(e);
        }

    }
    @PostMapping ("/data/{email}")
    public  ResponseEntity<?> addPizzatoUserDetalis(@RequestBody Pizza pizza, @PathVariable String email)
    {
        try
        {
          return   new ResponseEntity<>(userServiceInterface.saveOrderToList(pizza,email),HttpStatus.OK);
        } catch (UserNotFound e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/user/{email}")
    public  ResponseEntity<?> userAllPizzaListAccordingToUser(@PathVariable String email)
    {
        try
        {
            return  new ResponseEntity<>(userServiceInterface.getAllOrderFromList(email),HttpStatus.OK);
        } catch (UserNotFound e) {
            throw new RuntimeException(e);
        }
    }
}
