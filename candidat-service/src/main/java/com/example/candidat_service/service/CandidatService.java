package com.example.candidat_service.service;


import com.example.candidat_service.client.JobClient;
import com.example.candidat_service.dto.JobDTO;
import com.example.candidat_service.entity.Candidat;
import com.example.candidat_service.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private JobClient jobClient;

    // Méthodes pour les candidats
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    public Candidat getCandidatById(Long id) {
        return candidatRepository.findById(id).orElse(null);
    }

    public Candidat createCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    // Méthodes pour les jobs (via Feign)
    public List<JobDTO> getAllJobs() {
        return jobClient.getAllJobs();
    }

    public JobDTO getJobById(Long id) {
        return jobClient.getJobById(id);
    }

    public List<JobDTO> getAvailableJobs() {
        return jobClient.getAvailableJobs();
    }

    // Méthodes pour les favoris
    public List<JobDTO> getFavoriteJobs(Long candidatId) {
        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID: " + candidatId));

        return candidat.getFavoriteJobIds().stream()
                .map(jobClient::getJobById)
                .collect(Collectors.toList());
    }

    public void addFavoriteJob(Long candidatId, Long jobId) {
        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID: " + candidatId));

        // Vérifier si le job existe
        JobDTO job = jobClient.getJobById(jobId);
        if (job == null) {
            throw new RuntimeException("Job non trouvé avec l'ID: " + jobId);
        }

        candidat.getFavoriteJobIds().add(jobId);
        candidatRepository.save(candidat);
    }

    public void removeFavoriteJob(Long candidatId, Long jobId) {
        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID: " + candidatId));

        candidat.getFavoriteJobIds().remove(jobId);
        candidatRepository.save(candidat);
    }


}