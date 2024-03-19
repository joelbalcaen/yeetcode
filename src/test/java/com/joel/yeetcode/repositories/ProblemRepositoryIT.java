package com.joel.yeetcode.repositories;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import utils.ProblemTestUtils;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class ProblemRepositoryIT {
    @Autowired
    ProblemRepository problemRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void shouldSaveValidProblem() {
        // GIVEN
        final var entity = ProblemTestUtils.buildProblemEntity().toBuilder().id(null).build();

        // WHEN
        final var result = problemRepository.save(entity);

        // THEN
        assertThat(result).usingRecursiveComparison().ignoringFields("id").isEqualTo(entity);
        assertThat(result.getId()).isInstanceOf(Long.class);
    }
}
