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

import com.atestados.online.AtestadosOnline.Models.Doctor;
import com.atestados.online.AtestadosOnline.Service.DoctorService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/doctor")
@Api(tags = {"Médicos"})
public class DoctorController {
	
	private DoctorService doctorService;
	
	public DoctorController(DoctorService ds) {
		this.doctorService = ds;
	}
	
	@PostMapping
    public Doctor create(@Valid @RequestBody Doctor doctor) {
		return doctorService.createOrUpdate(doctor);
    }
	
	@GetMapping("")
    public ArrayList<Doctor> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("/{doctorId}")
    public Optional<Doctor> findById(@PathVariable long doctorId) {
        return doctorService.findById(doctorId);
    }

    @PutMapping("/{doctorId}")
    public Doctor update(@PathVariable long doctorId, @Valid @RequestBody Doctor doctor) {
        return doctorService.createOrUpdate(doctor);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteById(@PathVariable long doctorId) {
    	doctorService.deleteById(doctorId);
    }

}
