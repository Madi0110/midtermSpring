package net.alterapp.miniproject3.repo;

import net.alterapp.miniproject3.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
    Project findByIdAndDeletedAtIsNull(long id);
    List<Project> findAllByDeletedAtIsNull();
}
