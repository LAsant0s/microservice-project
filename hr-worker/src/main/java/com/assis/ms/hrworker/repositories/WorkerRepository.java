package com.assis.ms.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assis.ms.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
