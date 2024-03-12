package com.joel.yeetcode.dtos;

import com.joel.yeetcode.enums.ProblemDifficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ProblemDTO {
    Long id;
    String title;
    String description;
    List<String> constraints;
    ProblemDifficulty difficulty;
    ProblemCodeTemplateDTO templates;
}
