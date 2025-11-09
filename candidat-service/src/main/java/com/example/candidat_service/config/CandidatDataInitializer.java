package com.example.candidat_service.config;


import com.example.candidat_service.entity.Candidat;
import com.example.candidat_service.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CandidatDataInitializer implements CommandLineRunner {

    @Autowired
    private CandidatRepository candidatRepository;

    @Override
    public void run(String... args) throws Exception {
        // Création de candidats de test
        candidatRepository.save(new Candidat("Dupont", "Jean", "jean.dupont@email.com", "0123456789"));
        candidatRepository.save(new Candidat("Martin", "Marie", "marie.martin@email.com", "0987654321"));
        candidatRepository.save(new Candidat("Bernard", "Pierre", "pierre.bernard@email.com", "0654321987"));

        System.out.println("=== Candidats de test créés ===");
    }
}