package com.tcoshop.service.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcoshop.model.OrdersDetail;
@Repository
public interface OrdersDetailRepository extends JpaRepository<OrdersDetail, String>{
	@Query("SELECT o FROM OrdersDetail o where o.orders.id=?1")
	List<OrdersDetail> findOrdersDetailByOrderId(int orderId);
}
