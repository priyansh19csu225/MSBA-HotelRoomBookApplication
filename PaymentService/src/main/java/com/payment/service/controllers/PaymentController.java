package com.payment.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.service.entities.Payment;
import com.payment.service.models.TransactionDetails;
import com.payment.service.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;


	@RequestMapping(path="/initiate",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<TransactionDetails> completePayment(@RequestBody Payment paymentDetails) {
		int transactionID = paymentService.completeTransaction(paymentDetails);
		return ResponseEntity.ok().body(new TransactionDetails(transactionID));
	}
	
}
