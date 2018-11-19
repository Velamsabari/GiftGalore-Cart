package com.giftgalore.giftgalorebackend.DALayer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giftgalore.giftgalorebackend.model.Cart;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {
	@Autowired
	SessionFactory sessionfactory;


	public boolean CreateCart(Cart cart) 
	{
		try 
		{
			sessionfactory.getCurrentSession().save(cart);
									return true;
		}
			catch (Exception e) {
				return false;
			}
	}

	public boolean UpdateCart(Cart cart) {
		try
		{
		sessionfactory.getCurrentSession().update(cart);
		return true;
		}
		catch (Exception e) {
			return false;
		}}

	public boolean DeleteCart(int id) {
		try
		{
			Cart cart=(Cart)sessionfactory.getCurrentSession().createQuery("from Cart where itemid="+id).uniqueResult();
		sessionfactory.getCurrentSession().delete(cart);
					return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Cart> ViewCart(int id) {
		try {
			return sessionfactory.getCurrentSession()
					.createQuery("from Cart where cartid="+id
							).list();
		}

		catch (Exception e) {
			return new ArrayList<Cart>();
		}	}

	public Cart Showitem(int itemid) 
	{
		try
		{
		Cart cart=(Cart)sessionfactory.getCurrentSession().createQuery("from Cart where itemid="+itemid).uniqueResult();
		return cart;
		}
		catch (Exception e) {
			return null; 		}
	}

}
