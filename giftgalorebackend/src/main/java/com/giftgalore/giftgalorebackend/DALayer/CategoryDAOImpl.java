package com.giftgalore.giftgalorebackend.DALayer;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giftgalore.giftgalorebackend.model.Category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean CreateCategory(Category category) {
		try {
			System.out.println(category.getCategory_Name());
			sessionfactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}

	}

	public boolean UpdateCategory(Category category) {
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	public List<Category> ViewAllCategory() {
		try {
			System.out.println("hi");
			return sessionfactory.getCurrentSession().createQuery("from Category").list();
		}

		catch (Exception e) {
			return null;

		}
	}

	public Category ViewOneCategory(String CategoryName) {
		try {
			return (Category) sessionfactory.getCurrentSession()
					.createQuery("from Category where Category_Name='" + CategoryName + "'").uniqueResult();
		}

		catch (Exception e) {
			return null;

		}

	}

	public boolean DeleteCategory(Category category) {
		try {
			sessionfactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			return false;
		}	}
}