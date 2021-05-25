package net.alterapp.miniproject3.repo;

import net.alterapp.miniproject3.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    Contact findByIdAndDeletedAtIsNull(Long id);
    Contact findByPhoneNumberAndDeletedAtIsNull(String author);
    List<Contact> findAllByDeletedAtIsNull();
}
