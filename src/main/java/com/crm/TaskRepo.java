package com.crm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
    // Custom queries or methods can be added if needed
}

