package fr.ppe.controller;

import fr.ppe.entity.Product;
import fr.ppe.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.save(product);
    }
}
