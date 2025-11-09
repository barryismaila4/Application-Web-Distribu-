package com.example.job_service.controller;


import com.example.job_service.entity.Job;
import com.example.job_service.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.orElse(null);
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @GetMapping("/available")
    public List<Job> getAvailableJobs() {
        return jobRepository.findAll().stream()
                .filter(Job::getAvailable)
                .toList();
    }
    @Value("${welcome.message:Welcome to Job Service - DEFAULT}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }
}