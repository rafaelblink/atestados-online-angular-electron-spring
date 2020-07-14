package com.atestados.online.AtestadosOnline.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atestados.online.AtestadosOnline.Models.Inpatient;
import com.atestados.online.AtestadosOnline.Repository.InpatientRepository;
import com.google.common.collect.Lists;

@Service
public class InpatientServiceImpl implements InpatientService {
	
	private final InpatientRepository InpatientRepository;
	
	public InpatientServiceImpl(InpatientRepository dr) {
		this.InpatientRepository = dr;
	}
	
	@Override
	public ArrayList<Inpatient> findAll() {
		return Lists.newArrayList(InpatientRepository.findAll());
	}

	@Override
	public Inpatient createOrUpdate(Inpatient inpatient) {
		return InpatientRepository.save(inpatient);
	}

	@Override
	public Optional<Inpatient> findById(Long id) {
		return InpatientRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		InpatientRepository.deleteById(id);
		
	}

}
