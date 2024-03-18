package utils;

import com.joel.yeetcode.dtos.ProblemCodeTemplateDTO;
import com.joel.yeetcode.dtos.ProblemDTO;
import com.joel.yeetcode.entities.Problem;
import com.joel.yeetcode.enums.ProblemDifficulty;

import java.util.List;

public class ProblemTestUtils {

    public static ProblemDTO buildProblemDTO() {
        return ProblemDTO.builder()
                .id(1L)
                .title("blalblabla")
                .description("blalalb")
                .constraints(List.of("not too many numbers"))
                .difficulty(ProblemDifficulty.EASY)
                .templates(
                        ProblemCodeTemplateDTO.builder().javascript("").python("").build()
                )
                .build();
    }

    public static Problem buildProblemEntity() {
        return Problem.builder()
                .id(1L)
                .title("Some title")
                .description("Some description")
                .constraints(List.of("n cannot be 0"))
                .difficulty(ProblemDifficulty.MEDIUM)
                .templates(ProblemCodeTemplateDTO.builder().javascript("some JS code").python("some python code").build())
                .build();

    }
}
