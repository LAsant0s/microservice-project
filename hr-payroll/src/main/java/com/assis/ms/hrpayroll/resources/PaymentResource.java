package com.assis.ms.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assis.ms.hrpayroll.entities.Payment;
import com.assis.ms.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController()
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{WorkerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long WorkerId, @PathVariable Integer days) {
		Payment payment = service.getPayment(WorkerId, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long WorkerId, @PathVariable Integer days) {
		Payment payment = new Payment("Silvio Almeida", 800.0, days);
		return ResponseEntity.ok(payment);
	}
	
}
