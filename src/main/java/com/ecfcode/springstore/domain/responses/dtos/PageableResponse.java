package com.ecfcode.springstore.domain.responses.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageableResponse<T> {
    PageItem item;
    T response;
}
