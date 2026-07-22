package fr.ppe.config;

import fr.ppe.entity.Role;
import fr.ppe.entity.User;
import fr.ppe.repository.RoleRepository;
import fr.ppe.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        if (userRepository.findByUsername("admin").isPresent()) {
            return;
        }

        Role adminRole = roleRepository.findByName("ADMIN")
                .orElseGet(() -> {
                    Role role = new Role("ADMIN");
                    return roleRepository.save(role);
                });

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("Admin123!"));
        admin.setEmail("admin@ppe.local");
        admin.setEnabled(true);
        admin.setRole(adminRole);

        userRepository.save(admin);

        System.out.println("==================================");
        System.out.println("ADMIN CREATED");
        System.out.println("Username : admin");
        System.out.println("Password : Admin123!");
        System.out.println("==================================");
    }
}
