package com.hcl.quotation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RequestDto {
	
	private int userId;
	private int stockId;
	private int quantity;
	

}
