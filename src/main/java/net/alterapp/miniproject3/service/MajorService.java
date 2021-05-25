package net.alterapp.miniproject3.service;

import net.alterapp.miniproject3.domain.*;

import net.alterapp.miniproject3.repo.MajorRepo;
import net.alterapp.miniproject3.repo.ProfessorRepo;
import net.alterapp.miniproject3.repo.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MajorService {
    private final ProfessorRepo professorRepo;
    private final ProjectRepo projectRepo;
    private final ProfessorService professorService;
    private final StudentService studentService;
    private final ContactService contactService;
    private final MajorRepo majorRepo;

    public MajorService(ProfessorRepo professorRepo, ProjectRepo projectRepo, ProfessorService professorService, StudentService studentService, ContactService contactService, MajorRepo majorRepo) {
        this.professorRepo = professorRepo;
        this.projectRepo = projectRepo;
        this.professorService = professorService;
        this.studentService = studentService;
        this.contactService = contactService;
        this.majorRepo = majorRepo;
    }


    public Major findById(Long id) {
        return majorRepo.findByIdAndDeletedAtIsNull(id);
    }

    public Major addMajor(Major major) {
        return majorRepo.save(major);
    }

    public String updateAll(Long id, String name, Integer year) {
        Major major = majorRepo.findByIdAndDeletedAtIsNull(id);
        major.setName(name);
        major.setYear(year);
        majorRepo.save(major);
        return "updated all";
    }

    public String delete(Long id) {
        Date date = new Date();
        Major major = majorRepo.findByIdAndDeletedAtIsNull(id);
        major.setDeletedAt(date);
        majorRepo.save(major);
        return "deleted";
    }

    public List<Major> findAll() {
        return majorRepo.findAllByDeletedAtIsNull();
    }
}
