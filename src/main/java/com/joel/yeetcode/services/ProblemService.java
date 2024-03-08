package com.joel.yeetcode.services;

import com.joel.yeetcode.dtos.ProblemDTO;
import com.joel.yeetcode.mappers.ProblemMapper;
import com.joel.yeetcode.repositories.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final ProblemMapper problemMapper;

    public ProblemService(ProblemRepository problemRepository, ProblemMapper problemMapper) {
        this.problemRepository = problemRepository;
        this.problemMapper = problemMapper;
    }

    public ProblemDTO createProblem(ProblemDTO problem) {
        final var createdProblem = problemRepository.save(problemMapper.toEntity(problem));
        return problemMapper.toDto(createdProblem);
    }

    public List<ProblemDTO> getAllProblems() {
        return problemRepository.findAll().stream().map(problemMapper::toDto).toList();
    }

    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }
}
