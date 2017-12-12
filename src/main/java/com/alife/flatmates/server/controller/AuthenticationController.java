package com.alife.flatmates.server.controller;

import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alife.flatmates.exception.EmailAlreadyAvailable;
import com.alife.flatmates.exception.UserNameAlreadyAvailable;
import com.alife.flatmates.server.domain.ManagedUser;
import com.alife.flatmates.server.domain.User;
import com.alife.flatmates.server.security.SecurityUtils;
import com.alife.flatmates.server.service.UserService;
import com.alife.flatmates.server.util.JsonResponseBuilder;

@RestController
@RequestMapping(value="/")
public class AuthenticationController {

	private final UserService userService;

	private final PasswordEncoder passwordEncoder;

	public AuthenticationController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}



	@GetMapping(value="/auth")
	public String geLoggedInUserDetail(){
		return SecurityUtils.getCurrentUserLogin();
	}

	@PostMapping(value="/api/register",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object register(@RequestBody ManagedUser managedUser){

		boolean    isResultSuccess = false;
		Exception  exception       = null;
		User 	   user 		   = null;

		try{

			String userName = managedUser.getLogin();
			String email    = managedUser.getEmail();
			
			user = userService.findUserObjectWithId(userName);

			if(user.getId() != null){
				throw new UserNameAlreadyAvailable(userName);
			}
			
			if(email != null){
				user = userService.findUserObjectByEmailWithId(email);

				if(user.getId() != null){
					throw new EmailAlreadyAvailable(email);
				}

			}
			
			user = new User()
					.setLogin(userName)
					.setFirstName(managedUser.getFirstName())
					.setLastName(managedUser.getLastName())
					.setLangKey("en")
					.setEmail(email)
					.setPassword(passwordEncoder.encode(managedUser.getPassword()))
					.setActivated(true);

			user =  userService.save(user);

			if(user.getId() != null){
				isResultSuccess =  true;
			}

		}catch(Exception e){
			exception = e;
		}

		return JsonResponseBuilder.creatBasicJsonResponse(isResultSuccess, user, exception);
	}


}
