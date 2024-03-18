package com.joel.yeetcode.utils;

import com.joel.yeetcode.dtos.ProblemCodeTemplateDTO;
import com.joel.yeetcode.dtos.ProblemDTO;
import com.joel.yeetcode.enums.ProblemDifficulty;

import java.util.List;

public class ProblemTestUtils {

    public static ProblemDTO buildProblemDTO() {
        return ProblemDTO.builder()
                .id(1l)
                .title("blalblabla")
                .description("blalalb")
                .constraints(List.of("not too many numbers"))
                .difficulty(ProblemDifficulty.EASY)
                .templates(
                        ProblemCodeTemplateDTO.builder().javascript("").python("").build()
                )
                .build();
    }
}
