package net.alterapp.miniproject3.service;
;
import net.alterapp.miniproject3.domain.Project;
import net.alterapp.miniproject3.repo.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }


    public Project add(Project project) {
        return projectRepo.save(project);
    }

    public List<Project> findAll() {
        return projectRepo.findAllByDeletedAtIsNull();
    }

}
