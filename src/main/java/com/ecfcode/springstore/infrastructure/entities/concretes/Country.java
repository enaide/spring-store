package com.ecfcode.springstore.infrastructure.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="country_id")
	private int countryId;
	
	@Column(name = "country_name" )
	private String countryName;
	
	@OneToMany(mappedBy = "country")
	private List<City> cities;
	
/*	@OneToMany(mappedBy = "country")
	private List<Customer> customers;*/
	
	@OneToMany(mappedBy = "country")
	private List<Employee> employees;
	
	@OneToMany(mappedBy = "country")
	private List<Supplier> suppliers;
}
