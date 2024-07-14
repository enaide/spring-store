package com.ecfcode.springstore.infrastructure.abstracts;

import com.ecfcode.springstore.infrastructure.entities.concretes.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface CartProductRepository extends JpaRepository<CartProduct, Integer>{

	/*@Transactional
	@Modifying
	@Query("Delete from CartProduct Where cartId = :cartId")	
	void deleteCartWithCartId(@Param("cartId")int cartId);*/
}
