package com.joel.yeetcode.mappers;

import com.joel.yeetcode.dtos.ProblemDTO;
import com.joel.yeetcode.entities.Problem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProblemMapper {
    ProblemDTO toDto(Problem problem);
    Problem toEntity(ProblemDTO problem);
}
