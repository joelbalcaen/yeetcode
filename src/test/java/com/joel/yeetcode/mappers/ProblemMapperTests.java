package com.joel.yeetcode.mappers;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import utils.ProblemTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ProblemMapperTests {

    private final ProblemMapperImpl problemMapper = new ProblemMapperImpl();

    @Test
    void shouldMapToDTO() {
        // GIVEN
        final var entity = ProblemTestUtils.buildProblemEntity();

        // WHEN
        final var result = problemMapper.toDto(entity);

        // THEN
        assertThat(result).usingRecursiveComparison().isEqualTo(entity);
    }

    @Test
    void shouldMapToEntity() {
        // GIVEN
        final var dto = ProblemTestUtils.buildProblemDTO();

        // WHEN
        final var result = problemMapper.toEntity(dto);

        // THEN
        assertThat(result).usingRecursiveComparison().isEqualTo(dto);
    }


}
