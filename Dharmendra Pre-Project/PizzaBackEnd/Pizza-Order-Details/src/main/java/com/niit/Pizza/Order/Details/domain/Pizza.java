package com.niit.Pizza.Order.Details.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Pizza {
    private int  pizza_id;
    private  String prizza_name;
    private  String pizza_size;
    private  int pizza_price;
    private  int quantity;
    private  int total_price;
    private String imgUrl;
}
