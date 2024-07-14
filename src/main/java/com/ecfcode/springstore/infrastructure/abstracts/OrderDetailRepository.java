package com.ecfcode.springstore.infrastructure.abstracts;


import com.ecfcode.springstore.infrastructure.entities.concretes.OrderDetail;
import com.ecfcode.springstore.infrastructure.entities.concretes.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

	OrderDetail getByOrder_OrderIdAndProduct_ProductId( Long orderId,int productId);
	
	OrderDetail getByProduct_ProductId( int productId);
	
	
	@Transactional
	@Modifying  
	@Query(value = "Delete From order_details  Where order_id =?1 and product_id =?2", nativeQuery = true)
	void deleteOrderDetailWithOrderIdAndProductId(Long orderId, Long productId);
}
