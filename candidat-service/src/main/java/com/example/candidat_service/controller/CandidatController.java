package com.example.candidat_service.controller;

import com.example.candidat_service.dto.JobDTO;
import com.example.candidat_service.entity.Candidat;
import com.example.candidat_service.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    // === Routes pour les candidats ===
    @GetMapping
    public List<Candidat> getAllCandidats() {
        return candidatService.getAllCandidats();
    }

    @GetMapping("/{id}")
    public Candidat getCandidatById(@PathVariable Long id) {
        return candidatService.getCandidatById(id);
    }

    @PostMapping
    public Candidat createCandidat(@RequestBody Candidat candidat) {
        return candidatService.createCandidat(candidat);
    }

    // === Routes pour les jobs (via OpenFeign) ===
    @GetMapping("/jobs")
    public List<JobDTO> getAllJobs() {
        return candidatService.getAllJobs();
    }

    @GetMapping("/jobs/{id}")
    public JobDTO getJobById(@PathVariable Long id) {
        return candidatService.getJobById(id);
    }

    @GetMapping("/jobs/available")
    public List<JobDTO> getAvailableJobs() {
        return candidatService.getAvailableJobs();
    }

    // === Routes pour les favoris ===
    @GetMapping("/{candidatId}/favorites")
    public List<JobDTO> getFavoriteJobs(@PathVariable Long candidatId) {
        return candidatService.getFavoriteJobs(candidatId);
    }

    @PostMapping("/{candidatId}/favorites/{jobId}")
    public ResponseEntity<String> addFavoriteJob(@PathVariable Long candidatId, @PathVariable Long jobId) {
        try {
            candidatService.addFavoriteJob(candidatId, jobId);
            return ResponseEntity.ok("Job ajouté aux favoris avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{candidatId}/favorites/{jobId}")
    public ResponseEntity<String> removeFavoriteJob(@PathVariable Long candidatId, @PathVariable Long jobId) {
        try {
            candidatService.removeFavoriteJob(candidatId, jobId);
            return ResponseEntity.ok("Job retiré des favoris avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @Value("${welcome.message:Welcome to Candidat Service - DEFAULT}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }


}