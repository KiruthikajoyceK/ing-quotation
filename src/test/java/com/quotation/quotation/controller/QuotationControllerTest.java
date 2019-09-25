package com.quotation.quotation.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.quotation.controller.QuotationController;
import com.hcl.quotation.dto.RequestDto;
import com.hcl.quotation.dto.ResponseDto;
import com.hcl.quotation.service.QuotationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class QuotationControllerTest {

	@Autowired
	MockMvc mockMvc;
	@InjectMocks
	QuotationController quotationController;

	@Mock
	QuotationServiceImpl quotationServiceImpl;

	@Test
	public void testGetQuotation() throws Exception {

		ResponseDto responseDto=new ResponseDto();
		responseDto.setStockId(1);
		
		RequestDto requestDto=new RequestDto();
		requestDto.setStockId(1);
		Mockito.when(quotationServiceImpl.quotationDetails(requestDto)).thenReturn(responseDto);

		ResponseEntity<ResponseDto> response = quotationController.getQuotation(requestDto);
		assertEquals(200, response.getStatusCode().value());

	}
	


}
