package com.example.candidat_service.client;


import com.example.candidat_service.dto.JobDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "job-service", path = "/api/jobs")
public interface JobClient {

    @GetMapping
    List<JobDTO> getAllJobs();

    @GetMapping("/{id}")
    JobDTO getJobById(@PathVariable Long id);

    @GetMapping("/available")
    List<JobDTO> getAvailableJobs();
}