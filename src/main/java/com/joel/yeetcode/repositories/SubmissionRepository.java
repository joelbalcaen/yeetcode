package com.joel.yeetcode.repositories;

import com.joel.yeetcode.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    public Optional<Submission> findByIdAndOwnerEmail(Long id, String ownerEmail);
}
