package net.alterapp.miniproject3.service;

import net.alterapp.miniproject3.domain.Student;
import net.alterapp.miniproject3.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo clientRepo;


    public StudentService(StudentRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Student add(Student student) {
        return clientRepo.save(student);
    }

    public Student findById(long id) {
        return clientRepo.findByIdAndDeletedAtIsNull(id);
    }


    public List<Student> findAll() {
        return clientRepo.findAllByDeletedAtIsNull();
    }
}
