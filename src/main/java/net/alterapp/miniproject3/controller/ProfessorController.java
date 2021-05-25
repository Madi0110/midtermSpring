package net.alterapp.miniproject3.controller;

import net.alterapp.miniproject3.domain.Professor;
import net.alterapp.miniproject3.exception.ServiceException;
import net.alterapp.miniproject3.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RestController
@RequestMapping("/api/professor")
public class ProfessorController extends BaseController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Professor professor) throws ServiceException {
        return buildResponse(professorService.add(professor), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return buildResponse(professorService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        return buildResponse(professorService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/findName")
    public ResponseEntity<?> findName(@RequestParam String name) {
        return buildResponse(professorService.findByName(name), HttpStatus.OK);
    }
}
