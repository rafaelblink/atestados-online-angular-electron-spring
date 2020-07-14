package com.atestados.online.AtestadosOnline.Service;
import java.util.ArrayList;
import java.util.Optional;

import com.atestados.online.AtestadosOnline.Models.SickNote;

public interface SickNoteService {
	
	ArrayList<SickNote> findAll();

	SickNote createOrUpdate(SickNote sickNote);

	Optional<SickNote> findById(Long id);

    void deleteById(Long id);
	
}
