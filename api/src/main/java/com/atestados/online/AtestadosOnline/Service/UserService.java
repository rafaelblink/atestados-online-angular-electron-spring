package com.atestados.online.AtestadosOnline.Service;

import java.util.ArrayList;

import com.atestados.online.AtestadosOnline.Models.User;

public interface UserService {
	
	ArrayList<User> findAll();

    User create(User user);

    User findById(Long id);

    User update(Long id, User user);

    void deleteById(Long id);

}
