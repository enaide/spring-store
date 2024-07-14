package com.ecfcode.springstore.infrastructure.abstracts;

import com.ecfcode.springstore.infrastructure.entities.concretes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart getByCustomer_CustomerNumber(String customerNumber);
	
	/*@Transactional
	@Modifying
	@Query("Delete from Cart Where customer_number = :customerNumber")	
	void deleteCartWithCustomerNumber(@Param("customerNumber")String customerNumber);*/
}
