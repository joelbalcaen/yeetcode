package com.joel.yeetcode.services;

import com.joel.yeetcode.mappers.SubmissionMapperImpl;
import com.joel.yeetcode.repositories.SubmissionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import utils.SubmissionTestUtils;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class SubmissionServiceTests {
    private final SubmissionMapperImpl submissionMapper = new SubmissionMapperImpl();
    SubmissionService submissionService;
    @Mock
    SubmissionRepository submissionRepository;

    @BeforeEach
    void init() {
        submissionService = new SubmissionService(submissionRepository, submissionMapper);
    }

    @Test
    public void shouldGetSubmission() {
        // GIVEN
        final var submission = SubmissionTestUtils.buildSubmissionEntity();
        when(submissionRepository.findByIdAndOwnerEmail(any(), any())).thenReturn(Optional.of(submission));

        // WHEN
        final var result = submissionService.get(1L, "bla");

        // THEN
        assertThat(result.get()).isEqualTo(submissionMapper.toDto(submission));
    }


}
