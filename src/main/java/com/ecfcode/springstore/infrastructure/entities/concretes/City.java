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
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "city_name")
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
/*	@OneToMany(mappedBy="city")
	private List<Customer> customers;*/
	
	@OneToMany(mappedBy = "city")
	private List<Employee> employees;
	
	@OneToMany(mappedBy = "city")
	private List<Supplier> suppliers;
}
