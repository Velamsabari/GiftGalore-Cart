package com.giftgalore.giftgalorebackend.DALayer;

import java.util.List;

import com.giftgalore.giftgalorebackend.model.MyOrder;

public interface OrderDAO {
	boolean Placeorder(MyOrder order);
	List<MyOrder> ViewOrder(int cartid);	
	MyOrder Showorder(String orderid);
}
