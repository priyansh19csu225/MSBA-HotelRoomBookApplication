package com.payment.service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.service.entities.Payment;

public interface PaymentDAO extends JpaRepository<Payment,Integer>{

}
