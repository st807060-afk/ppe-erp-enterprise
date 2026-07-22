package fr.ppe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VersionController {

    @GetMapping("/api/version")
    public Map<String, String> version() {
        return Map.of(
                "name", "PPE ERP Enterprise",
                "version", "0.0.1"
        );
    }
}
