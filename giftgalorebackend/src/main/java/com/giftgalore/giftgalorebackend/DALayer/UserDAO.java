package com.giftgalore.giftgalorebackend.DALayer;

import com.giftgalore.giftgalorebackend.model.UserDetails;

public interface UserDAO {

	boolean CreateUserDetails(UserDetails userdetails);
	boolean UpdateUserDetails(UserDetails userdetails);
	boolean DeleteUserDetails(UserDetails userdetails);
	UserDetails SelectUser(String Emailid);


}
