package com.ecfcode.springstore.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	ModelMapper forResponse();
	ModelMapper forRequest();
}
