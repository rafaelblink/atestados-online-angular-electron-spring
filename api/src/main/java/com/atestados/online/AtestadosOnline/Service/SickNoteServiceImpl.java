package com.atestados.online.AtestadosOnline.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atestados.online.AtestadosOnline.Models.SickNote;
import com.atestados.online.AtestadosOnline.Repository.SickNoteRepository;
import com.google.common.collect.Lists;

@Service
public class SickNoteServiceImpl implements SickNoteService {
	
	private final SickNoteRepository sickNoteRepository;
	
	public SickNoteServiceImpl(SickNoteRepository snr) {
		this.sickNoteRepository = snr;
	}
	
	@Override
	public ArrayList<SickNote> findAll() {
		return Lists.newArrayList(sickNoteRepository.findAll());
	}

	@Override
	public SickNote createOrUpdate(SickNote sickNote) {
		return sickNoteRepository.save(sickNote);
	}

	@Override
	public Optional<SickNote> findById(Long id) {
		return sickNoteRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		sickNoteRepository.deleteById(id);
		
	}

}
