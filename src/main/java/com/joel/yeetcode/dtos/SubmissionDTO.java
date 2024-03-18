package com.joel.yeetcode.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joel.yeetcode.enums.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SubmissionDTO {
    @JsonIgnore
    Long id;

//    Long problem;

    ProgrammingLanguage codeLanguage;
    String code;


//    @JsonIgnore
//    SubmissionStatus status;
    @JsonIgnore
    String ownerEmail;
}
