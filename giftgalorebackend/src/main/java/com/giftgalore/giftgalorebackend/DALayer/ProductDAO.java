
package com.giftgalore.giftgalorebackend.DALayer;

import java.util.List;

import com.giftgalore.giftgalorebackend.model.MyProduct;

public interface ProductDAO {
	
	boolean CreateProduct(MyProduct product);
	boolean UpdateProduct(MyProduct product);
	boolean DeleteProduct(MyProduct product);
	MyProduct SelectProduct(int Product_id);
	List<MyProduct> SelectAllProduct();
	List<MyProduct> SelectCatProduct(String Category_Name);


}




