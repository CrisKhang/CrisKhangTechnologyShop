package com.tcoshop.service.shoppingCart;

import java.util.Collection;

import com.tcoshop.model.Product;


public interface ShoppingCartService {
	Product add(Integer id, int quantity);
	
	void remove(Integer id);
	
	Product update(Integer id, int qty);
	
	void clear();
	
	int getCount();
	
	double getAmount();
	
	double getTax();
	
	double getShipping();
	
	Collection<Product> getProducts();
}
