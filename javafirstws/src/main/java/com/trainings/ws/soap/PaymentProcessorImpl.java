package com.trainings.ws.soap;

import com.trainings.ws.soap.dto.PaymentProcessorRequest;
import com.trainings.ws.soap.dto.PaymentProcessorResponse;


public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(
			PaymentProcessorRequest paymentProcessorRequest) {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		//Business Logic or a call  to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
