package com.giftgalore.giftgalorebackend.DALayer;


import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giftgalore.giftgalorebackend.model.UserCred;
import com.giftgalore.giftgalorebackend.model.UserDetails;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean CreateUserDetails(UserDetails userdetails) {

		try {
		
		UserCred c=new UserCred();
		c.setEmailid(userdetails.getEmailid());
		c.setUser_Password(userdetails.getUser_password());
		c.setRole("ROLE_USER");
		c.setStatus("True");
		sessionfactory.getCurrentSession().save(userdetails);
		sessionfactory.getCurrentSession().save(c);
		
		return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean UpdateUserDetails(UserDetails userdetails)
	{
		try
		{
		sessionfactory.getCurrentSession().update(userdetails);
		return true;
		}
		catch (Exception e) {
			return false;
		}
		

	}

	public boolean DeleteUserDetails(UserDetails userdetails) 
	{
		try
		{
		sessionfactory.getCurrentSession().delete(userdetails);
		UserCred cred=
		(UserCred)sessionfactory.getCurrentSession()
		.createQuery("from UserCred where Emailid='"+userdetails.getEmailid()+"'").uniqueResult();
		sessionfactory.getCurrentSession().delete(cred);

		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public UserDetails SelectUser(String emailid) {
		try {
			return (UserDetails) sessionfactory.getCurrentSession()
					.createQuery("from UserDetails where Emailid='" + emailid + "'").uniqueResult();
		}

		catch (Exception e) {
			return null;
		}
	}
}



