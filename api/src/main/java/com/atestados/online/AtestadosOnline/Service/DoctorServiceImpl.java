package com.atestados.online.AtestadosOnline.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atestados.online.AtestadosOnline.Models.Doctor;
import com.atestados.online.AtestadosOnline.Repository.DoctorRepository;
import com.google.common.collect.Lists;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	private final DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(DoctorRepository dr) {
		this.doctorRepository = dr;
	}
	
	@Override
	public ArrayList<Doctor> findAll() {
		return Lists.newArrayList(doctorRepository.findAll());
	}

	@Override
	public Doctor createOrUpdate(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Optional<Doctor> findById(Long id) {
		return doctorRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		doctorRepository.deleteById(id);
		
	}

}
