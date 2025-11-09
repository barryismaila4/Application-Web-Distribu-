package com.example.candidat_service.dto;


public class JobDTO {
    private Long id;
    private String title;
    private String description;
    private String department;
    private Double salary;
    private Boolean available;

    // Constructeurs
    public JobDTO() {}

    public JobDTO(Long id, String title, String description, String department, Double salary, Boolean available) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.department = department;
        this.salary = salary;
        this.available = available;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "JobDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", available=" + available +
                '}';
    }
}