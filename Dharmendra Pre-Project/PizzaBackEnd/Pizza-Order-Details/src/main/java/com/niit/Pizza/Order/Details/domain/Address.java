package com.niit.Pizza.Order.Details.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    private  int house_number;
    private String house_name;
    private String  city;
    private  int zipcode;
}
