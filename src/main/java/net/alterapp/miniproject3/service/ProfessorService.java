package net.alterapp.miniproject3.service;


import net.alterapp.miniproject3.domain.Professor;
import net.alterapp.miniproject3.repo.ProfessorRepo;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProfessorService {
    private final ProfessorRepo professorRepo;

    public ProfessorService(ProfessorRepo professorRepo) {
        this.professorRepo = professorRepo;
    }

    public Professor add(Professor professor) {
        return professorRepo.save(professor);
    }

    public Professor findById(long id) {
        return professorRepo.findByIdAndDeletedAtIsNull(id);
    }

    public Professor findByName(String name) {
        return professorRepo.findByNameAndDeletedAtIsNull(name);
    }

    public String delete(long id) {
        Date date = new Date();
        Professor professor = professorRepo.findByIdAndDeletedAtIsNull(id);
        professor.setDeletedAt(date);
        professorRepo.save(professor);
        return "deleted";
    }
}
