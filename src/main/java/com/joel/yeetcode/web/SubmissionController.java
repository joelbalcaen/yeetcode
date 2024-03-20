package com.joel.yeetcode.web;

import com.joel.yeetcode.dtos.SubmissionDTO;
import com.joel.yeetcode.services.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequiredArgsConstructor
public class SubmissionController {
    private final String rootPath = "/submissions";

    private final SubmissionService submissionService;

    @PostMapping(rootPath)
    void submit(@RequestBody SubmissionDTO submissionDTO) {
        submissionService.submit(submissionDTO);
    }

    @GetMapping(rootPath + "/{id}")
    SubmissionDTO get(@PathVariable Long id) {
        return submissionService.get(id, "tokenEmail").orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
