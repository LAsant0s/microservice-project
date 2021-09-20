package com.assis.ms.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.ms.hrpayroll.entities.Payment;
import com.assis.ms.hrpayroll.entities.Worker;
import com.assis.ms.hrpayroll.feignClients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, Integer days) {
		Worker obj = workerFeignClient.findById(workerId).getBody();
		return new Payment(obj.getName(), obj.getDailyIncome(), days);
	}

}
