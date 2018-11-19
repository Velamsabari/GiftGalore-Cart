package com.giftgalore.giftgalorebackend.DALayer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giftgalore.giftgalorebackend.model.MyOrder;
@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO 
{
	@Autowired
	SessionFactory sessionfactory;

	public boolean Placeorder(MyOrder order) {
		try 
		{
			sessionfactory.getCurrentSession().save(order);
									return true;
		}
			catch (Exception e) {
				return false;
			}
	}

	public List<MyOrder> ViewOrder(int id) {
		try {
			return sessionfactory.getCurrentSession()
					.createQuery("from MyOrder where cartid="+id
							).list();
		}

		catch (Exception e) {
			return new ArrayList<MyOrder>();
		}	
	}

	public MyOrder Showorder(String orderid) {
		try
		{
			MyOrder order=(MyOrder)sessionfactory.getCurrentSession().createQuery("from MyOrder where orderid='"+orderid+"'").uniqueResult();
		return order;
		}
		catch (Exception e) {
			return null; 		}
	}

}
