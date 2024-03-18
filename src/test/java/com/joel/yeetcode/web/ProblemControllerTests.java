package com.joel.yeetcode.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.yeetcode.dtos.ProblemDTO;
import com.joel.yeetcode.services.ProblemService;
import com.joel.yeetcode.utils.ProblemTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProblemController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ProblemControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProblemService problemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldGetAllProblems() throws Exception {
        final List<ProblemDTO> problems = List.of(ProblemTestUtils.buildProblemDTO());
        final String problemJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(problems);
        Mockito.when(problemService.getAllProblems()).thenReturn(problems);
       mockMvc.perform(get("/problems")).andExpect(status().isOk()).andExpect(content().json(problemJSON));
    }
}
