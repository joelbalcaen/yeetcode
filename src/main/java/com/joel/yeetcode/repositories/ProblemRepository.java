package com.joel.yeetcode.repositories;

import com.joel.yeetcode.entities.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
