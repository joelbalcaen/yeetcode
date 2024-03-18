package utils;

import com.joel.yeetcode.dtos.SubmissionDTO;
import com.joel.yeetcode.entities.Submission;
import com.joel.yeetcode.enums.ProgrammingLanguage;

public class SubmissionTestUtils {
    public static SubmissionDTO buildProblemDTO() {
        return SubmissionDTO.builder()
                .id(1L)
                .codeLanguage(ProgrammingLanguage.PYTHON)
                .code("BlaBla")
                .ownerEmail("jobalcaen@gmail.com")
                .build();
    }

    public static Submission buildSubmissionEntity() {
        return Submission.builder()
                .id(1L)
                .codeLanguage(ProgrammingLanguage.PYTHON)
                .code("BlaBla")
                .ownerEmail("jobalcaen@gmail.com")
                .build();
    }
}
