package net.alterapp.miniproject3.repo;

import net.alterapp.miniproject3.controller.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);
}
