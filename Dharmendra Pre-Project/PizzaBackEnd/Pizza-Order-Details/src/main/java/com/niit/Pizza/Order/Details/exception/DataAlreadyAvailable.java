package com.niit.Pizza.Order.Details.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Data Already Available")
public class DataAlreadyAvailable extends  Exception{
}
