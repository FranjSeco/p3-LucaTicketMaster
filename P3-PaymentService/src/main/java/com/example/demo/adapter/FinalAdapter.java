package com.example.demo.adapter;

import com.example.demo.model.ResultModel;
import com.example.demo.response.FinalResultResponse;

public class FinalAdapter {
	public FinalResultResponse of(ResultModel finalResult) {
		FinalResultResponse finalResultResponse = new FinalResultResponse();
		finalResultResponse.setEventResponse(finalResult.getEventInfoResult());
		finalResultResponse.setPaymentResponse(finalResult.getPaymentResult());
		
		return finalResultResponse;
	}

}
