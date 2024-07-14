package com.ecfcode.springstore.infrastructure.abstracts;

import com.ecfcode.springstore.infrastructure.entities.concretes.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
