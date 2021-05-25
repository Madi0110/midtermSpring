package net.alterapp.miniproject3.repo;

import net.alterapp.miniproject3.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByIdAndDeletedAtIsNull(long id);;
    List<Student> findAllByDeletedAtIsNull();
}
