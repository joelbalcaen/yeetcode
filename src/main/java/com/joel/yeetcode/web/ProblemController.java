package com.joel.yeetcode.web;


import com.joel.yeetcode.dtos.ProblemCodeTemplateDTO;
import com.joel.yeetcode.dtos.ProblemDTO;
import com.joel.yeetcode.entities.Problem;
import com.joel.yeetcode.repositories.ProblemRepository;
import com.joel.yeetcode.services.ProblemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProblemController {
    private final String rootPath = "/problems";
    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping(rootPath)
    List<ProblemDTO> all() {
        return problemService.getAllProblems();
    }


    @PostMapping(rootPath)
    ProblemDTO createProblem(@RequestBody ProblemDTO problem) {
        return problemService.createProblem(problem);
    }

    @DeleteMapping(rootPath+"/{id}")
    void deleteProblem(@PathVariable Long id) {
        problemService.deleteProblem(id);
    }


}
