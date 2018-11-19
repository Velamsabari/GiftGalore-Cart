package com.giftgalore.giftgalorebackend.DALayer;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.giftgalore.giftgalorebackend.model.Address;


@Repository
@Transactional
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean CreateAddress(Address address) {

		try {
			sessionfactory.getCurrentSession().save(address);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean UpdateAddress(Address address) {
		try {
			sessionfactory.getCurrentSession().update(address);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean DeleteAddress(int id) {
		try {

			sessionfactory.getCurrentSession().delete(SelectoneAddress(id));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Address> SelectallAddress(int cartid) {
		try {
			return sessionfactory.getCurrentSession().createQuery("from Address where cartid=" + cartid).list();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;

		}
	}

	public Address SelectoneAddress(int addressid) {
		try {
			System.out.println("2");
			return (Address) sessionfactory.getCurrentSession().createQuery("from Address where addressid=" + addressid)
					.uniqueResult();
		}

		catch (Exception e) {
			return null;

		}

	}
}