package com.joel.yeetcode.dtos;

import com.joel.yeetcode.enums.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SubmissionDTO {
    Long id;
    ProgrammingLanguage codeLanguage;
    String code;
}
