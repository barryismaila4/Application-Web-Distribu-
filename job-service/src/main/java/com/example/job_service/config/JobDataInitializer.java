package com.example.job_service.config;


import com.example.job_service.entity.Job;
import com.example.job_service.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JobDataInitializer implements CommandLineRunner {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public void run(String... args) throws Exception {
        // Création de jobs de test
        jobRepository.save(new Job("Développeur Java", "Développement applications Spring Boot", "IT", 45000.0, true));
        jobRepository.save(new Job("Analyste Financier", "Analyse des données financières", "Finance", 50000.0, true));
        jobRepository.save(new Job("Chef de Projet", "Gestion de projets IT", "Management", 55000.0, false));
        jobRepository.save(new Job("Data Scientist", "Analyse de données et machine learning", "IT", 52000.0, true));

        System.out.println("=== Jobs de test créés ===");
    }
}