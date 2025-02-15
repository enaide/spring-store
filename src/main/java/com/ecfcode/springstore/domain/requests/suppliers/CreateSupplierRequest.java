package com.ecfcode.springstore.domain.requests.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierRequest {
	private int supplierId;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	
	private int cityId;
	private int countyId;
}
