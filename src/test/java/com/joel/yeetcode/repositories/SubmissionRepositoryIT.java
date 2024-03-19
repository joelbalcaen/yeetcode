package com.joel.yeetcode.repositories;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import utils.SubmissionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SubmissionRepositoryIT {

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    EntityManager entityManager;


    @Test
    public void shouldSaveValidSubmission() {
        // GIVEN
        final var entity = SubmissionTestUtils.buildSubmissionEntity().toBuilder().id(null).build();

        // WHEN
        final var result = submissionRepository.save(entity);

        // THEN
        assertThat(result).usingRecursiveComparison().ignoringFields("id").isEqualTo(entity);
        assertThat(result.getId()).isInstanceOf(Long.class);
    }


    @Test
    public void shouldFindByIdAndOwnerEmail() {
        // GIVEN
        final var ownerEmail = "jojo@bla.com";
        final var entity1 = SubmissionTestUtils.buildSubmissionEntity().toBuilder().ownerEmail(ownerEmail).id(null).build();
        final var entity2 = SubmissionTestUtils.buildSubmissionEntity().toBuilder().id(null).build();
        final var createdEntity1 = submissionRepository.save(entity1);
        submissionRepository.save(entity2);

        // WHEN
        final var result = submissionRepository.findByIdAndOwnerEmail(createdEntity1.getId(), ownerEmail);

        // THEN
        assertThat(result.get()).usingRecursiveComparison().isEqualTo(createdEntity1);
    }


}
