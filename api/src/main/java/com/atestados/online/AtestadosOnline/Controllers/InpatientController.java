package com.atestados.online.AtestadosOnline.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atestados.online.AtestadosOnline.Models.Inpatient;
import com.atestados.online.AtestadosOnline.Service.InpatientService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/inpatient")
@Api(tags = {"Pacientes"})
public class InpatientController {
	
	private InpatientService inpatientService;
	
	public InpatientController(InpatientService ds) {
		this.inpatientService = ds;
	}
	
	@PostMapping
    public Inpatient create(@Valid @RequestBody Inpatient inpatient) {
		return inpatientService.createOrUpdate(inpatient);
    }
	
	@GetMapping("")
    public ArrayList<Inpatient> findAll() {
        return inpatientService.findAll();
    }

    @GetMapping("/{inpatientId}")
    public Optional<Inpatient> findById(@PathVariable long inpatientId) {
        return inpatientService.findById(inpatientId);
    }

    @PutMapping("/{inpatientId}")
    public Inpatient update(@PathVariable long inpatientId, @Valid @RequestBody Inpatient inpatient) {
        return inpatientService.createOrUpdate(inpatient);
    }

    @DeleteMapping("/{inpatientId}")
    public void deleteById(@PathVariable long inpatientId) {
    	inpatientService.deleteById(inpatientId);
    }

}
