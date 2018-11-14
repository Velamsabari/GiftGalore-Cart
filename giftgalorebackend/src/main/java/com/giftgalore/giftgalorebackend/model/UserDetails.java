package com.giftgalore.giftgalorebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Cart_id;

	public int getCart_id() {
		return Cart_id;
	}

	public void setCart_id(int cart_id) {
		Cart_id = cart_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Column(nullable = false)
	@NotBlank(message = "UserName is mandatory")
	private String user_name;

	@Column(nullable = false,unique=true)
	@Email(regexp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",message="Please enter a valid Email id")
	private String emailid;

	@Column(nullable = false)
	//@NotNull(message = "Mobileno is mandatory")
	@Pattern(regexp = "[6789][0-9]{9}", message = "Not a valid mobile number.Mobile number must be in 10 digits")
	private String mobileno;
	
	@Column(nullable = false)
	//@NotNull(message = "User_password is mandatory")
	@Pattern(regexp = "(?=^.{8,16}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;'?/&gt;.&lt;,])(?!.*\\s).*$",message="Must Have  1 number 1 LowerCase 1UpperCase and 1 spl Char min size 8 max size 16")
	@Transient
	private String user_password;

	}
