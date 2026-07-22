package fr.ppe.controller;

import fr.ppe.entity.Customer;
import fr.ppe.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.findAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.save(customer);
    }
}
