package net.alterapp.miniproject3.controller;


import net.alterapp.miniproject3.domain.Major;
import net.alterapp.miniproject3.service.MajorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/major")
public class MajorController extends BaseController {
    private final MajorService majorService;

    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Major major) {
        return buildResponse(majorService.addMajor(major), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam long id) {
        return buildResponse(majorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/updateAll")
    public ResponseEntity<?> updateAll(@RequestParam Long id, String name, Integer year) {
        return buildResponse(majorService.updateAll(id, name, year), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam long id) {
        return buildResponse(majorService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(majorService.findAll(), HttpStatus.OK);
    }

}
