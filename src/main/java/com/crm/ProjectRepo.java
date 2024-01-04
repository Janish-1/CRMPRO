package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    // Custom queries or methods can be added if needed
}

