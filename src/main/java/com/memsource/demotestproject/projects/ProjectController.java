package com.memsource.demotestproject.projects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/api/projects")
    public ResponseEntity<ProjectResponseDTO> getProjects(@RequestParam int pageNumber) {
        return ResponseEntity.ok(projectService.getProject(pageNumber));
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ProjectResponseDTO> handleHttpException(HttpClientErrorException e) {
        log.error("Http error: ", e);
        return ResponseEntity.badRequest().body(ProjectResponseDTO.empty());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProjectResponseDTO> handleException(Exception e) {
        log.error("Error: ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ProjectResponseDTO.empty());
    }
}
