package com.niit.services;

import com.niit.domain.User;
//import com.niit.proxy.UserProxy;
import com.niit.repositery.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//This annotation is a Spring stereotype annotation used to mark this class as a service component, indicating that it contains business logic.
public class UserServices implements  InterService{
    UserRepositery userRepositery;
//This is a constructor for the UserServices class that is annotated with @Autowired. It is used for dependency injection.
//It receives an instance of UserRepositery as a parameter and sets it as an instance variable. This allows the service to interact with the repository for user data.
@Autowired
    public UserServices(UserRepositery userRepositery) {
        this.userRepositery = userRepositery;
    }
//@Override: This annotation indicates that this method is an implementation of a method declared in the interface InterService.
    @Override
    public User addData(User user) {
      if (userRepositery.findById(user.getEmail()).isEmpty())
      {
          return userRepositery.save(user);
      }
      return null;
    }
//retrieves all user data from the repository by calling the findAll method on the userRepositery. The findAll method is typically provided by JPA (Java Persistence API) repositories and returns all records of the specified entity type (in this case, User) from the database.
    @Override
    public List<User> getAllData() {
        return userRepositery.findAll();
    }
//This method takes an email address (String email) as a parameter and is responsible for deleting the user with the provided email from the repository.
//    a user with the provided email exists in the repository. It does so by calling findById(email) on the userRepositery. If no user is found with the provided email, isEmpty() returns true, indicating that the user does not exist in the repository.
//
//If the condition in the if statement is true (i.e., the user does not exist), the method returns the following message:
//
//return "Data Not Available";: This message indicates that the data with the provided email is not available for deletion.
    @Override
    public String DeleteData(String email) {
       if (userRepositery.findById(email).isEmpty())
       {
           return  "Data Not Available";
       }
       userRepositery.deleteById(email);
       return "Data delete Successfully";
    }

    @Override
    public User Update(User user) {
      if (userRepositery.findById(user.getEmail()).isEmpty())
      {
          return  null;
      }
      User tempUser=userRepositery.findById(user.getEmail()).get();

      tempUser.setFirstName(user.getFirstName());
      tempUser.setLastName(user.getLastName());
      tempUser.setPassword(user.getPassword());

      return  userRepositery.save(tempUser);

    }

    @Override
    public List<User> getAllUserByFirstName(String firstName) {
        return userRepositery.findByfirstName(firstName);
    }

    @Override
    public User loginCheck(String email, String password) {
     if (userRepositery.findById(email).isPresent())
     {
         //fetch user object by email id
         User result=userRepositery.findById(email).get();
         if (result.getPassword().equals(password))
         {
             return result;
         }
         else
         {
             return null;
         }
     }
     else
     {
         return null;
     }
    }
}
