package com.demo.CRUD_OPERATIONS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Create a new project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        projectService.createProject(project);
        return project;
    }

    // Read all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // read a project by ID
    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable int id) {
        return projectService.getAllProjectsById(id);
    }

    // Update a project
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable int id, @RequestBody Project projectDetails) {
        return projectService.updateProduct(id, projectDetails);
    }

    // Delete a project
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
    }
}
