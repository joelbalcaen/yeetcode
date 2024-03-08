package com.joel.yeetcode.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProblemDTO {
    Long id;
    String title;
    String description;
}
