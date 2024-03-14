package com.joel.yeetcode.repositories;

import com.joel.yeetcode.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
