package com.joel.yeetcode.mappers;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import utils.SubmissionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class SubmissionMapperTests {

    private final SubmissionMapper submissionMapper = new SubmissionMapperImpl();

    @Test
    void shouldMapToDTO() {
        // GIVEN
        final var entity = SubmissionTestUtils.buildSubmissionEntity();

        // WHEN
        final var result = submissionMapper.toDto(entity);

        // THEN
        assertThat(result).usingRecursiveComparison().isEqualTo(entity);
    }

    @Test
    void shouldMapToEntity() {
        // GIVEN
        final var dto = SubmissionTestUtils.buildSubmissionDTO();

        // WHEN
        final var result = submissionMapper.toEntity(dto);

        // THEN
        assertThat(result).usingRecursiveComparison().isEqualTo(dto);
    }
}
