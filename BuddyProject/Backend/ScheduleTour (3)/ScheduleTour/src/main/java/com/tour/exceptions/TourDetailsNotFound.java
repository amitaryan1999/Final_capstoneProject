package com.tour.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Tour Details Not Found")
public class TourDetailsNotFound extends Exception{

}
