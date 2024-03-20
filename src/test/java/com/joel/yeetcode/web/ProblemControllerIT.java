package com.joel.yeetcode.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.yeetcode.dtos.ProblemDTO;
import com.joel.yeetcode.services.ProblemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import utils.ProblemTestUtils;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class ProblemControllerIT {
    private final String rootPath = "/problems";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProblemService problemService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetAllProblems() throws Exception {
        final List<ProblemDTO> problems = List.of(ProblemTestUtils.buildProblemDTO(), ProblemTestUtils.buildProblemDTO());
        final String problemJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(problems);
        Mockito.when(problemService.getAllProblems()).thenReturn(problems);
        mockMvc.perform(get(rootPath)).andExpect(status().isOk()).andExpect(content().json(problemJSON));
        verify(problemService).getAllProblems();
    }

    @Test
    void shouldCreateProblem() throws Exception {
        final var problemToCreate = ProblemTestUtils.buildProblemDTO();
        final String problemJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(problemToCreate);
        Mockito.when(problemService.createProblem(any())).thenReturn(problemToCreate);
        final var request = post(rootPath).contentType(MediaType.APPLICATION_JSON).content(problemJSON);
        mockMvc.perform(request).andExpect(status().isCreated()).andExpect(content().json(problemJSON));
        verify(problemService).createProblem(problemToCreate);
    }

    @Test
    void shouldDeleteProblem() throws Exception {
        final var problemId = 2L;
        mockMvc.perform(delete(rootPath + "/" + problemId)).andExpect(status().isOk());
        verify(problemService).deleteProblem(problemId);
    }
}
