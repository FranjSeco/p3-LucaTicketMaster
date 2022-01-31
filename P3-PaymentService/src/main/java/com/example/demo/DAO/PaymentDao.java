package com.example.demo.DAO;

import com.example.demo.model.PaymentModel;

public class PaymentDao {
	public PaymentModel paymentSuccesful() {
		PaymentModel payment =new PaymentModel("0","Todo correcto");
		return payment;
		
	}
	public PaymentModel cardDeclined() {
		PaymentModel payment =new PaymentModel("1","Tarjeta rechazada");
		return payment;
		
	}
	public PaymentModel notEnoughBalance() {
		PaymentModel payment =new PaymentModel("2","Saldo insuficiente en la cuenta");
		return payment;
		
	}
	public PaymentModel paymentDeclined() {
		PaymentModel payment =new PaymentModel("3","Superado el saldo diario");
		return payment;
		
	}

}
