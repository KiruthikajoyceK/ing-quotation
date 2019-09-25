package com.hcl.quotation.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.quotation.dto.RequestDto;
import com.hcl.quotation.dto.ResponseDto;
import com.hcl.quotation.dto.StockDto;
import com.hcl.quotation.entity.Quotation;
import com.hcl.quotation.repository.QuotationRepository;

@Service
public class QuotationServiceImpl implements QuotationIntf{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	QuotationRepository quotationRepository;
	
	public ResponseDto quotationDetails(RequestDto requestDto)
	{
		ResponseDto responseDto=new ResponseDto();
		
		ResponseEntity<StockDto> stockDto = restTemplate.getForEntity("http://localhost:9090/stock/stock/stockDetails/{stockId}", StockDto.class, requestDto.getStockId());
		double uniquePrice=stockDto.getBody().getStockPrice();
		double total=uniquePrice*requestDto.getQuantity();
		double brokarageAmount=total*0.05;
		double totalPrice=total+brokarageAmount;
		
		
		Quotation quotation=new Quotation();
		quotation.setQuantity(requestDto.getQuantity());
		quotation.setStockId(requestDto.getStockId());
		quotation.setStockPrice(uniquePrice);
		quotation.setTotalPrice(totalPrice);
		quotation.setUserId(requestDto.getUserId());
		 BeanUtils.copyProperties(quotation, responseDto);
		 responseDto.setBrokarageAmount(brokarageAmount);
			
		quotationRepository.save(quotation);
		
		return responseDto;
		
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
