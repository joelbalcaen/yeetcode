package com.joel.yeetcode.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.yeetcode.dtos.ProblemCodeTemplateDTO;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProblemCodeTemplateConverter implements AttributeConverter<ProblemCodeTemplateDTO, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ProblemCodeTemplateDTO template) {
        try {
            return objectMapper.writeValueAsString(template);
        } catch (JsonProcessingException jpe) {
            return null;
        }
    }

    @Override
    public ProblemCodeTemplateDTO convertToEntityAttribute(String value) {
        try {
            return objectMapper.readValue(value, ProblemCodeTemplateDTO.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}