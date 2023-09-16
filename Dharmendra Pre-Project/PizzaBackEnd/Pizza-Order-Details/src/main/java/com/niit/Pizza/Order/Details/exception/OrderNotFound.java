package com.niit.Pizza.Order.Details.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Order not Found")
public class OrderNotFound extends  Exception{
}
