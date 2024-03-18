package com.joel.yeetcode.web;


import com.joel.yeetcode.dtos.ProblemDTO;
import com.joel.yeetcode.services.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
// this is not great as it allows all origins
// try to set it globally before deploying for real
@CrossOrigin
public class ProblemController {
    final String rootPath = "/problems";
    private final ProblemService problemService;

    @GetMapping(rootPath)
    List<ProblemDTO> all(Principal principal) {
        return problemService.getAllProblems();
    }

    @PostMapping(rootPath)
    @ResponseStatus(HttpStatus.CREATED)
    ProblemDTO createProblem(@RequestBody ProblemDTO problem) {
        return problemService.createProblem(problem);
    }

    @DeleteMapping(rootPath + "/{id}")
    void deleteProblem(@PathVariable Long id) {
        problemService.deleteProblem(id);
    }


}
