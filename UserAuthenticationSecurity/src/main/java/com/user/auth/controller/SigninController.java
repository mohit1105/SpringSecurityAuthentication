package com.user.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

	@RequestMapping("/signin")
	public String Signin() {
		return "login";
	}
}