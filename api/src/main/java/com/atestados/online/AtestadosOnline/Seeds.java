package com.atestados.online.AtestadosOnline;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.atestados.online.AtestadosOnline.Models.Role;
import com.atestados.online.AtestadosOnline.Models.RoleName;
import com.atestados.online.AtestadosOnline.Models.User;
import com.atestados.online.AtestadosOnline.Repository.RoleRepository;
import com.atestados.online.AtestadosOnline.Repository.UserRepository;

/**
 * This class loads data mainly for testing
 */
@Component
public class Seeds implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Seeds(RoleRepository rr, UserRepository ur, PasswordEncoder pe) {
        this.roleRepository = rr;
        this.userRepository = ur;
        this.passwordEncoder = pe;
    }

    @Override
    public void run(String... args) {

//        // Load roles
//        roleRepository.saveAll(Arrays.asList(
//                new Role(1, RoleName.ROLE_ADMIN),
//                new Role(2, RoleName.ROLE_USER)));
//
//        Set<Role> onlyAdmin = Collections.singleton(roleRepository.findByName(RoleName.ROLE_ADMIN).orElseThrow(RuntimeException::new));
//        Set<Role> onlyUser = Collections.singleton(roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(RuntimeException::new));
//
//        String hashPwd = passwordEncoder.encode("123");
//
//        // Load users
//        // Saving password in plain text, for now
//        userRepository.saveAll(Arrays.asList(
//                new User(null, "User A", "email_a@email.com", hashPwd, onlyAdmin, true),
//                new User(null, "User B", "email_b@email.com", hashPwd, onlyUser, true)
//        ));
    }
}
