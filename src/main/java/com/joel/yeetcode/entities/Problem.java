package com.joel.yeetcode.entities;

import com.joel.yeetcode.dtos.ProblemCodeTemplateDTO;
import com.joel.yeetcode.enums.ProblemDifficulty;
import com.joel.yeetcode.mappers.ProblemCodeTemplateConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Problem {
    private @Id
    @GeneratedValue Long id;
    private String title;
    /**
     * Description of the problem in markdown format
     */
    private String description;

    private List<String> constraints;

    @Enumerated(EnumType.ORDINAL)
    private ProblemDifficulty difficulty;

    @Convert(converter = ProblemCodeTemplateConverter.class)
    private ProblemCodeTemplateDTO templates;
}
