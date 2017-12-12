package com.alife.flatmates.server.domain;


import com.alife.flatmates.server.domain.constants.ApplicationConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * A user.
 */
@Entity
@Table(name = "user")
public class User extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Pattern(regexp = ApplicationConstants.LOGIN_REGEX)
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String login;

	@JsonIgnore
	//@NotNull
	@Size(min = 60, max = 60)
	@Column(name = "password_hash",length = 60)
	private String password;

	@Size(max = 50)
	@Column(name = "first_name", length = 50)
	private String firstName;

	@Size(max = 50)
	@Column(name = "last_name", length = 50)
	private String lastName;

	@Email
	@Size(max = 100)
	@Column(length = 100, unique = true)
	private String email;

	@NotNull
	@Column(nullable = false)
	private boolean activated = false;

	@Size(min = 2, max = 5)
	@Column(name = "lang_key", length = 5)
	private String langKey;

	@Size(max = 256)
	@Column(name = "image_url", length = 256)
	private String imageUrl;

	@Size(max = 20)
	@Column(name = "activation_key", length = 20)
	@JsonIgnore
	private String activationKey;

	@JsonIgnore
	@Size(max = 20)
	@Column(name = "reset_key", length = 20)
	private String resetKey;


	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "user_authority",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
	@BatchSize(size = 20)
	private Set<Authority> authorities = new HashSet<>();



	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	public String getLogin() {
		return login;
	}

	//Lowercase the login before saving it in database
	public User setLogin(String login) {
		this.login = login.trim().toLowerCase(Locale.ENGLISH);
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public User setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public boolean getActivated() {
		return activated;
	}

	public User setActivated(boolean activated) {
		this.activated = activated;
		return this;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public User setActivationKey(String activationKey) {
		this.activationKey = activationKey;
		return this;
	}

	public String getResetKey() {
		return resetKey;
	}

	public User setResetKey(String resetKey) {
		this.resetKey = resetKey;
		return this;
	}


	public String getLangKey() {
		return langKey;
	}

	public User setLangKey(String langKey) {
		this.langKey = langKey;
		return this;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public User setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
		return this;
	}

	public User() {
	}


	public User(Long id, String login, String firstName, String lastName, String email, boolean activated) {
		this.id = id;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.activated = activated;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"login='" + login + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", activated='" + activated + '\'' +
				", langKey='" + langKey + '\'' +
				", activationKey='" + activationKey + '\'' +
				"}";
	}
}
