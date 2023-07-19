package com.api.feingconfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.model.User;


@FeignClient(name = "register-service", url = "http://localhost:8082/register/")
public interface UserRestConsumer {

	@GetMapping("/getUserByEmail/{email}")
	public User getUserByEmailHandler(@PathVariable String email);
}
