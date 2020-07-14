package com.atestados.online.AtestadosOnline.Service;

import java.util.ArrayList;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atestados.online.AtestadosOnline.Exceptions.ConflictException;
import com.atestados.online.AtestadosOnline.Exceptions.NotFoundException;
import com.atestados.online.AtestadosOnline.Models.User;
import com.atestados.online.AtestadosOnline.Repository.RoleRepository;
import com.atestados.online.AtestadosOnline.Repository.UserRepository;
import com.google.common.collect.Lists;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository ur, PasswordEncoder pe, RoleRepository rr) {
        this.userRepository = ur;
        this.passwordEncoder = pe;
        this.roleRepository = rr;
    }

    @Override
    public User create(User user) {
        checkEmailExists(user);
        checkRolesExist(user);

        String hashPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPwd);
        return userRepository.save(user);
    }
    
    @Override
    public ArrayList<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário", id));
    }

    @Override
    public User update(Long id, User user) {
        User dbUser = findById(id);
        user.setId(dbUser.getId());

        // Update email
        if (!dbUser.getEmail().equals(user.getEmail())) {
            checkEmailExists(user);
        }

        checkRolesExist(user);
        String hashPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPwd);
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = findById(id);
        userRepository.deleteById(user.getId());
    }

    private void checkEmailExists(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ConflictException("Email já existe");
        }
    }

    private void checkRolesExist(User user) {
        user.getRoles().forEach(r -> {
            if (!roleRepository.existsById(r.getId())) {
                throw new NotFoundException("Papel", r.getId());
            }
        });
    }
}
