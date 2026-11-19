package com.carrerpilot.job_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carrerpilot.job_service.entity.Job;
import com.carrerpilot.job_service.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public Job updateJob(Long id, Job updatedJob) {

        Job job = jobRepository.findById(id).orElse(null);

        if (job != null) {
            job.setTitle(updatedJob.getTitle());
            job.setCompany(updatedJob.getCompany());
            job.setLocation(updatedJob.getLocation());
            job.setDescription(updatedJob.getDescription());
            job.setJobType(updatedJob.getJobType());
            job.setRequiredSkills(updatedJob.getRequiredSkills());
            job.setSalary(updatedJob.getSalary());

            return jobRepository.save(job);
        }

        return null;
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}