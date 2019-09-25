package com.hcl.quotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.quotation.dto.RequestDto;
import com.hcl.quotation.dto.ResponseDto;
import com.hcl.quotation.service.QuotationIntf;


@RestController
@RequestMapping("/quotation")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class QuotationController {

	@Autowired
	QuotationIntf  quotationServiceImpl ;

	@PostMapping("/quotationDetails")
	public ResponseEntity<ResponseDto> getQuotation(@RequestBody RequestDto requestDto) {
	
			ResponseDto responseDto=quotationServiceImpl.quotationDetails(requestDto);
		
	return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
			

	}

	
}
