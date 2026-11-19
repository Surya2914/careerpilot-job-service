package com.carrerpilot.job_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.carrerpilot.job_service.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
