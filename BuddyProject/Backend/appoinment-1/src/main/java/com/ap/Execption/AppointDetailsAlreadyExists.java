package com.ap.Execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason="Tour Details Already Exist")
public class AppointDetailsAlreadyExists extends Exception{

}
