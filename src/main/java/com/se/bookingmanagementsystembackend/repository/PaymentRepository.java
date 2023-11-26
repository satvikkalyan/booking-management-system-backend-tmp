package com.se.bookingmanagementsystembackend.repository;

import com.se.bookingmanagementsystembackend.business.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
