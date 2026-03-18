package es.jllopezalvarez.ejemplos.ejemplo20issuetracker.api.controllers;

import es.jllopezalvarez.ejemplos.ejemplo20issuetracker.common.dto.api.ProjectDto;
import es.jllopezalvarez.ejemplos.ejemplo20issuetracker.common.entities.Project;
import es.jllopezalvarez.ejemplos.ejemplo20issuetracker.common.mappers.ProjectMapper;
import es.jllopezalvarez.ejemplos.ejemplo20issuetracker.common.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectService projectService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @GetMapping
    ResponseEntity<List<ProjectDto>> findAll() {
//        return ResponseEntity.notFound().build();
//        return ResponseEntity.status(HttpStatus.CONFLICT).build();
        return ResponseEntity.ok(projectService.findAll().stream().map(projectMapper::map).toList());

    }

    @GetMapping("/{id}")
    ResponseEntity<ProjectDto> findById(@PathVariable Long id) {
        Optional<Project> optionalProject = projectService.findById(id);
        if (optionalProject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projectMapper.map(optionalProject.orElseThrow()));
    }

//    private ProjectDto map(Project project) {
//        return ProjectDto.builder()
//                .projectId(project.getProjectId())
//                .name(project.getName())
//                .description(project.getDescription())
//                .build();
//    }

}
