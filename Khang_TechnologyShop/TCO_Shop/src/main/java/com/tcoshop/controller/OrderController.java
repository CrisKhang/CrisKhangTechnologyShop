package com.tcoshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcoshop.model.Account;
import com.tcoshop.model.Orders;
import com.tcoshop.model.OrdersDetail;
import com.tcoshop.service.database.OrdersDetailRepository;
import com.tcoshop.service.database.OrdersRepository;
import com.tcoshop.service.session.SessionService;
import com.tcoshop.service.shoppingCart.ShoppingCartServiceImplement;

@Controller
public class OrderController {
	@Autowired
	SessionService sessionService;
	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	OrdersDetailRepository ordersDetailRepository;
	@Autowired
	ShoppingCartServiceImplement shoppingCart;
	
	@ModelAttribute("shoppingCart")
	public ShoppingCartServiceImplement getShoppingCart() {
		return shoppingCart;
	}
	@RequestMapping("/home/order")
	public String getOrderHistoryPage(Model model, @RequestParam("page") Optional<Integer> page) {
		Account account = sessionService.getAttribute("user");
		Pageable pageable = PageRequest.of(page.orElse(0), 10);
		Page<Orders> orders = ordersRepository.findOrdersByUserName(pageable, account.getUsername());
		model.addAttribute("orders",orders);
		return "home/order";
	}
	
	@RequestMapping("/home/order/detail")
	public String getOrderDetail(Model model, @RequestParam("orderId") int orderId) {
		List<OrdersDetail> ordersDetails = ordersDetailRepository.findOrdersDetailByOrderId(orderId);
		double total = ordersDetails.get(0).getOrders().getPrice();
		model.addAttribute("ordersDetails",ordersDetails);
		model.addAttribute("totalPrice", total);
		return "home/order/detail";
	}
}
