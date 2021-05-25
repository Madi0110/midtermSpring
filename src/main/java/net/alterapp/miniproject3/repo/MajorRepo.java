package net.alterapp.miniproject3.repo;


import net.alterapp.miniproject3.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepo extends JpaRepository<Major, Long> {
    Major findByIdAndDeletedAtIsNull(Long id);
    List<Major> findAllByDeletedAtIsNull();
}
