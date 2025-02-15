package com.ecfcode.springstore.infrastructure.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
	
	@Id
	@Column(name="supplier_id")
	private Long supplierId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="contact_name")
	private String contactName;
	
	@Column(name="contact_title")
	private String contactTitle;

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="region")
	private String region;

	@Column(name="postal_code")
	private String postal_code;

	@Column(name="country")
	private String country;

	@Column(name="phone")
	private String phone;

	@Column(name="fax")
	private String fax;

	@Column(name="homepage")
	private String homepage;

	/*@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;*/

	@OneToMany(mappedBy="supplier")
	private List<Product> products;


}
