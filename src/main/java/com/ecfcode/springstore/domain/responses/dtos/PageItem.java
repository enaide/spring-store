package com.ecfcode.springstore.domain.responses.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageItem {

	 int pageNo;
	 int pageSize;
	 int totalPages;
	 long totalData;
}
