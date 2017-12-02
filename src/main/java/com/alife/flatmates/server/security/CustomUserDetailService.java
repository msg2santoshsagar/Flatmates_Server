package com.alife.flatmates.server.security;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alife.flatmates.server.domain.User;
import com.alife.flatmates.server.service.UserService;

/**
 * Custom class to manage user authentication
 * 
 * @author santosh sagar
 *
 */
@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	Long counter = 0L;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String login)  {

		System.out.println("\n\n Request to loadUserByUsername  "+(counter ++)+" - "+login+"\n\n");
		if(counter == Long.MAX_VALUE){
			counter = 0L;
		}

		String lowercaseLogin = login.toLowerCase();

		Optional<User> userOptional = userService.findOneByLogin(lowercaseLogin);

		if ( userOptional.isPresent() ){
			// If User is available
			User user = userOptional.get();
			if( ! user.getActivated()){
				throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
			}

			List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
					.map(authority -> new SimpleGrantedAuthority(authority.getName()))
					.collect(Collectors.toList());
			System.out.println("\n\nROLE LIST "+grantedAuthorities+"\n\n");
			return  new org.springframework.security.core.userdetails.User(lowercaseLogin,
					user.getPassword(),
					grantedAuthorities);

		}else{
			throw new UsernameNotFoundException("User "+lowercaseLogin+" was not found in database.");
		}

	}

}
