package com.joel.yeetcode.mappers;

import com.joel.yeetcode.dtos.SubmissionDTO;
import com.joel.yeetcode.entities.Submission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {

    Submission toEntity(SubmissionDTO submission);

    SubmissionDTO toDto(Submission submission);

}
