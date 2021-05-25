package net.alterapp.miniproject3.controller;

import net.alterapp.miniproject3.domain.Contact;
import net.alterapp.miniproject3.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/contact")
public class ContactController extends BaseController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Contact contact) {
        return buildResponse(contactService.add(contact), HttpStatus.OK);
    }

    @PostMapping("/add/address")
    public ResponseEntity<?> addAddress(@RequestBody Contact contact) {
        return buildResponse(contactService.addAddress(contact), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return buildResponse(contactService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByAuthor")
    public ResponseEntity<?> findByPhoneNumber(@RequestParam String author) {
        return buildResponse(contactService.findByPhoneNumber(author), HttpStatus.OK);
    }

    @PostMapping("/updateAddress")
    public ResponseEntity<?> updateAddress(@RequestParam long id, String address) {
        return buildResponse(contactService.updateAddress(id, address), HttpStatus.OK);
    }

    @PostMapping("/updateAll")
    public ResponseEntity<?> updateAll(@RequestParam long id, String address, String phoneNumber) {
        return buildResponse(contactService.updateAll(id, address, phoneNumber), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam long id) {
        return buildResponse(contactService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(contactService.findAll(), HttpStatus.OK);
    }

}
