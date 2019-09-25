package com.quotation.quotation.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hcl.quotation.dto.RequestDto;
import com.hcl.quotation.dto.ResponseDto;
import com.hcl.quotation.dto.StockDto;
import com.hcl.quotation.entity.Quotation;
import com.hcl.quotation.repository.QuotationRepository;
import com.hcl.quotation.service.QuotationServiceImpl;

@RunWith(MockitoJUnitRunner.class)

public class QuotationServiceImplTest {

	@InjectMocks
	private QuotationServiceImpl quotationServiceImpl;

	@Mock
	private QuotationRepository quotationRepository;

	//private static final Logger LOGGER = LoggerFactory.getLogger(QuotationServiceImplTest.class);

	StockDto stockDto = new StockDto();

	Quotation returnQuotation = new Quotation();

	RequestDto requestDto=new RequestDto();
	
	@Mock
	RestTemplate restTemplate ;

	ResponseDto responseDto=new ResponseDto();
	
	@Before

	public void setProperties() {

		stockDto.setStockId(3);

		stockDto.setStockPrice(10.15);

		returnQuotation.setQuantity(10);

		returnQuotation.setStockId(3);

		returnQuotation.setStockPrice(3000.0);

		returnQuotation.setTotalPrice(100000);
		
		
		
		requestDto.setStockId(3);
		requestDto.setQuantity(10);
		requestDto.setUserId(1);
		
		responseDto.setBrokarageAmount(1234.0);
		responseDto.setQuantity(10);
		responseDto.setStockId(3);
		responseDto.setStockPrice(3000.0);
		responseDto.setTotalPrice(2345.0);
		responseDto.setUserId(1);

	}

	@Test

	public void testQuotationDetails() {

		String stockResourceUrl ="http://localhost:9090/stock/stock/stockDetails/{stockId}" ;
		
		//StockDto stockDto=restTemplate.exchange(stockResourceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<StockDto>() {
		//},requestDto.getStockId()).getBody();
		
				
				
		//ResponseEntity<StockDto> stockDto=restTemplate.getForEntity(stockResourceUrl, StockDto.class, requestDto.getStockId());
		
		Mockito.when(restTemplate.getForEntity(stockResourceUrl, StockDto.class, requestDto.getStockId())).thenReturn(new ResponseEntity<StockDto>(HttpStatus.OK));
		
		//Mockito.when(quotationServiceImpl.quotationDetails(requestDto)).thenReturn(responseDto);
		Mockito.when(quotationRepository.save(returnQuotation)).thenReturn(returnQuotation);
		
		//Assert.assertEquals(stockDto.getStockId(), returnQuotation.getStockId());

		

	}

	

}