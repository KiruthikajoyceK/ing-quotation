package com.hcl.quotation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {
	
	    private int userId;
		private int stockId;
		private double stockPrice;
		private int quantity;
		private double totalPrice;
		private double brokarageAmount;

	}

