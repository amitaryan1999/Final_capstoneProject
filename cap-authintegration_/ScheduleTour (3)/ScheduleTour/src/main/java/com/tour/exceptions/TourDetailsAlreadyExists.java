package com.tour.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason="Tour Details Already Exist")
public class TourDetailsAlreadyExists extends Exception{

}
