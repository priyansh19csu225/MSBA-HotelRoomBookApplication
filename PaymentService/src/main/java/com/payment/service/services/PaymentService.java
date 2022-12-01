package com.payment.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.service.DAO.PaymentDAO;
import com.payment.service.entities.Payment;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;
	
	public int completeTransaction(Payment payment) {
		return paymentDAO.save(payment).getId();
	}
}
