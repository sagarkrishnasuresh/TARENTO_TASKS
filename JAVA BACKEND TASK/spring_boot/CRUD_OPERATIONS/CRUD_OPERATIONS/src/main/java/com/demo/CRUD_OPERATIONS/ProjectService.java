package com.demo.CRUD_OPERATIONS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProjectService {


    @Autowired
    ProjectRepo repo;

    public void createProject(Project project) {
        repo.save(project);

    }

    public List<Project> getAllProjects() {
        return repo.findAll();
    }

    public Optional<Project> getAllProjectsById(int id) {
        return repo.findById(id);
    }

    public Project updateProduct(int id, Project productDetails) {
        Project project = repo.findById(id).orElse(null);
        if (project != null) {
            project.setName(productDetails.getName());
            project.setBudget(productDetails.getBudget());
            return repo.save(project);
        }
        return null;
    }
    public void deleteProject(int id) {
        repo.deleteById(id);
    }
}
