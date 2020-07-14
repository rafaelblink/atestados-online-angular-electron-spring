package com.atestados.online.AtestadosOnline.Service;
import java.util.ArrayList;
import java.util.Optional;

import com.atestados.online.AtestadosOnline.Models.Inpatient;

public interface InpatientService {
	
	ArrayList<Inpatient> findAll();

	Inpatient createOrUpdate(Inpatient inpatient);

	Optional<Inpatient> findById(Long id);

    void deleteById(Long id);
	
}
