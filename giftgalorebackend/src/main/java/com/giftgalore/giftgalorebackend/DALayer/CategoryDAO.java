
package com.giftgalore.giftgalorebackend.DALayer;

import java.util.List;

import com.giftgalore.giftgalorebackend.model.Category;


public interface CategoryDAO {
	
	boolean CreateCategory(Category c);
	boolean UpdateCategory(Category category);
	boolean DeleteCategory(Category category);
	List<Category> ViewAllCategory();
	Category ViewOneCategory(String category_Name);


}





