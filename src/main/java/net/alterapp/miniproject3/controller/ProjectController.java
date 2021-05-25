package net.alterapp.miniproject3.controller;

import net.alterapp.miniproject3.domain.Project;
import net.alterapp.miniproject3.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RestController
@RequestMapping("/api/project")
public class ProjectController extends BaseController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Project project) {
        return buildResponse(projectService.add(project), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(projectService.findAll(), HttpStatus.OK);
    }
}
