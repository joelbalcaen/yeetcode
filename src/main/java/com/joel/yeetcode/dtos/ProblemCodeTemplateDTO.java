package com.joel.yeetcode.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProblemCodeTemplateDTO {
    public ProblemCodeTemplateDTO() {}
    public String javascript;
    public String python;
}
