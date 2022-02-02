package com.example.demo.adapter;

import org.springframework.stereotype.Component;

import com.example.demo.response.FinalResultResponse;

@Component
public class FinalAdapter {
	public FinalResultResponse of(FinalResultResponse finalResult) {
		FinalResultResponse finalResultResponse = new FinalResultResponse();
		finalResultResponse.setEventResponse(finalResult.getEventResponse());
		finalResultResponse.setPaymentResponse(finalResult.getPaymentResponse());
		
		return finalResultResponse;
	}

}
