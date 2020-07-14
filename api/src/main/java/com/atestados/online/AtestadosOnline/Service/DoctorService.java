package com.atestados.online.AtestadosOnline.Service;
import java.util.ArrayList;
import java.util.Optional;

import com.atestados.online.AtestadosOnline.Models.Doctor;

public interface DoctorService {
	
	ArrayList<Doctor> findAll();

	Doctor createOrUpdate(Doctor doctor);

	Optional<Doctor> findById(Long id);

    void deleteById(Long id);
	
}
