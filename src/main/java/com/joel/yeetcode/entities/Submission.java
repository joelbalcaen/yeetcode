package com.joel.yeetcode.entities;

import com.joel.yeetcode.enums.ProgrammingLanguage;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Submission {
    private @Id
    @GeneratedValue Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "problem_id", referencedColumnName = "id")
    Problem problem;

    ProgrammingLanguage codeLanguage;
    String code;
}
