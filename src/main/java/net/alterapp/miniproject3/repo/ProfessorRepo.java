package net.alterapp.miniproject3.repo;

import net.alterapp.miniproject3.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {
    Professor findByIdAndDeletedAtIsNull(Long id);
    Professor findByNameAndDeletedAtIsNull(String name);
}
