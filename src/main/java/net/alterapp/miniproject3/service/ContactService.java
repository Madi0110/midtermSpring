package net.alterapp.miniproject3.service;

import net.alterapp.miniproject3.domain.Contact;
import net.alterapp.miniproject3.repo.ContactRepo;
import net.alterapp.miniproject3.repo.MajorRepo;
import net.alterapp.miniproject3.repo.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.*;

@Service
public class ContactService {
    private final MajorRepo majorRepo;
    private final ProfessorService professorService;
    private final ProjectRepo projectRepo;
    private final ContactRepo contactRepo;

    public ContactService(MajorRepo majorRepo, ProfessorService professorService, ProjectRepo projectRepo, ContactRepo contactRepo) {
        this.majorRepo = majorRepo;
        this.professorService = professorService;
        this.projectRepo = projectRepo;
        this.contactRepo = contactRepo;
    }


    public Contact add(Contact contact) {
        return contactRepo.save(contact);
    }


    public Contact addAddress(Contact contact) {
        Contact c = new Contact();
        c.setAddress(contact.getAddress());
        return contactRepo.save(contact);
    }


    public Contact findById(Long id) {
        return contactRepo.findByIdAndDeletedAtIsNull(id);
    }

    public Contact findByPhoneNumber(String phoneNumber) {
        return contactRepo.findByPhoneNumberAndDeletedAtIsNull(phoneNumber);
    }


    public String updateAddress(long id, String address) {
        Contact contact = contactRepo.findByIdAndDeletedAtIsNull(id);
        contact.setAddress(address);
        contactRepo.save(contact);
        return "updated address";
    }


    public String updateAll(long id, String address, String phoneNumber) {
        Contact contact = contactRepo.findByIdAndDeletedAtIsNull(id);
        contact.setAddress(address);
        contact.setPhoneNumber(phoneNumber);
        contactRepo.save(contact);
        return "updated all";
    }


    public String delete(long id) {
        Date date = new Date();
        Contact contact = contactRepo.findByIdAndDeletedAtIsNull(id);
        contact.setDeletedAt(date);
        contactRepo.save(contact);
        return "deleted";
    }

    public List<Contact> findAll() {
        return contactRepo.findAllByDeletedAtIsNull();
    }
}
