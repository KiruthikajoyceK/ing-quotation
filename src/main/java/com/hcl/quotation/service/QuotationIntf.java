package com.hcl.quotation.service;

import com.hcl.quotation.dto.RequestDto;
import com.hcl.quotation.dto.ResponseDto;

public interface QuotationIntf {
	
	public ResponseDto quotationDetails(RequestDto requestDto);
	

}
