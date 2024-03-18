package com.joel.yeetcode.services;

import com.joel.yeetcode.mappers.ProblemMapperImpl;
import com.joel.yeetcode.repositories.ProblemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import utils.ProblemTestUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class ProblemServiceTests {
    private final ProblemMapperImpl problemMapper = new ProblemMapperImpl();
    ProblemService problemService;
    @Mock
    ProblemRepository problemRepository;

    @BeforeEach
    void init() {
        problemService = new ProblemService(problemRepository, problemMapper);
    }

    @Test
    public void shouldCreateProblem() {
        // GIVEN
        final var problemToCreate = ProblemTestUtils.buildProblemDTO();
        final var createdProblem = problemMapper.toEntity(problemToCreate);
        when(problemRepository.save(any())).thenReturn(createdProblem);

        // WHEN
        final var result = problemService.createProblem(problemToCreate);

        // THEN
        assertThat(result).isEqualTo(problemToCreate);
    }

    @Test
    public void shouldGetAllProblems() {
        // GIVEN
        final var problems = List.of(ProblemTestUtils.buildProblemEntity());
        when(problemRepository.findAll()).thenReturn(problems);

        // WHEN
        final var result = problemService.getAllProblems();

        // THEN
        assertThat(result).isEqualTo(problems.stream().map(problemMapper::toDto).toList());
    }
}
