package controllers;
import Entites.Phone;
import repositories.interfaces.PhRepos;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    private final PhoneRepository repo;

    public PhoneController(PhoneRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<PhoneEntity> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public PhoneEntity getById(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public PhoneEntity create(@RequestBody PhoneEntity phone) {
        return repo.save(phone);
    }

    @PutMapping("/{id}")
    public PhoneEntity update(@PathVariable Integer id, @RequestBody PhoneEntity phone) {
        phone.setId(id);
        return repo.save(phone);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return "Deleted phone " + id;
    }
}

