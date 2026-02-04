import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<CustomerEntity> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public CustomerEntity getById(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public CustomerEntity create(@RequestBody CustomerEntity customer) {
        return repo.save(customer);
    }

    @PutMapping("/{id}")
    public CustomerEntity update(@PathVariable Integer id, @RequestBody CustomerEntity customer) {
        customer.setId(id);
        return repo.save(customer);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return "Deleted customer " + id;
    }
}

