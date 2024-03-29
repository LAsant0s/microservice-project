package com.assis.ms.hrworker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assis.ms.hrworker.entities.Worker;
import com.assis.ms.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repository;
	
	public List<Worker> findAll() {
		return repository.findAll();	
	}
	
	public Worker findById(Long id) {
		return repository.findById(id).get();
	}

}
