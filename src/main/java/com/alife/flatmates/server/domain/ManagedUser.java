package com.alife.flatmates.server.domain;

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ManagedUser {
	
	private Long	 id;
    private String 	 login;
    private String	 password;
    private String 	 firstName;
    private String 	 lastName;
    private String 	 email;
    private boolean	 activated = true;
    private String	 langKey;
    private String	 imageUrl;
    private String	 activationKey;
    private String	 resetKey;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login.trim().toLowerCase(Locale.ENGLISH);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public String getLangKey() {
		return langKey;
	}
	public void setLangKey(String langKey) {
		this.langKey = langKey;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getActivationKey() {
		return activationKey;
	}
	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}
	public String getResetKey() {
		return resetKey;
	}
	public void setResetKey(String resetKey) {
		this.resetKey = resetKey;
	}
    
    
	

}
