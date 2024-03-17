package com.joel.yeetcode.services;


import com.joel.yeetcode.dtos.SubmissionDTO;
import com.joel.yeetcode.mappers.SubmissionMapper;
import com.joel.yeetcode.repositories.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;

    private final SubmissionMapper submissionMapper;

    public void submit(SubmissionDTO submissionDTO) {
        final var entity = submissionMapper.toEntity(submissionDTO);
        submissionRepository.save(entity);
    }

    public Optional<SubmissionDTO> get(Long id, String ownerEmail) {
        return submissionRepository.findByIdAndOwnerEmail(id, ownerEmail).map(submissionMapper::toDto);
    }
}
