package com.niit.Pizza.Order.Details.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class User {

    @Id
    private String email;
    private  String firstName;
    private  String lastName;
    private  String password;
    private List<Pizza> pizzaDetailsList;
}
