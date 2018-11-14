
package com.giftgalore.giftgalorebackend.DALayer;

import java.util.List;

import com.giftgalore.giftgalorebackend.model.Cart;


public interface CartDAO {
	
	boolean CreateCart(Cart cart);
	boolean UpdateCart(Cart cart);
	boolean DeleteCart(int id);
	List<Cart> ViewCart(int cartid);
}





