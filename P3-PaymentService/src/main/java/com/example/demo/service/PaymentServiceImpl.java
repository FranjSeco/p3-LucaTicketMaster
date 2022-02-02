package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.PaymentDao;
import com.example.demo.adapter.PaymentAdapter;
import com.example.demo.controller.PaymentController;
import com.example.demo.model.PaymentModel;
import com.example.demo.response.PaymentResponse;

@Service
public class PaymentServiceImpl implements PaymentService {
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	PaymentAdapter paymentAdapter;

	@Override
	public PaymentModel processPayment() {
		// TODO Auto-generated method stub
		log.info("Se accede al procesamiento del pago");
		int numero=(int) (Math.random()*9);	
		return processPayment(numero);
	}
	@Override
	public PaymentModel processPayment(int numero) {
		// TODO Auto-generated method stub
		log.info("Se accede al procesamiento del pago");
		PaymentModel payment = null;
		if(numero<=6) {
			payment=new PaymentDao().paymentSuccesful();
			
		}else if(numero>6 & numero<=7) {
			payment=new PaymentDao().cardDeclined();
			
		}else if(numero>7 & numero<=8) {
			payment=new PaymentDao().notEnoughBalance();
			
		}else if(numero>8) {
			payment=new PaymentDao().paymentDeclined();
		}
		
		return payment;
	}
	
	@Override
	public PaymentResponse paymentResult() {
		return paymentAdapter.of(processPayment());
	}

}