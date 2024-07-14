package com.ecfcode.springstore.infrastructure.abstracts;

import com.ecfcode.springstore.infrastructure.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByCustomerNumber(String id);
}
