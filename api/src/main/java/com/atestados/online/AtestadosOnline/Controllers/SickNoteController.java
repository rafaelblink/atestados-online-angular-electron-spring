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

import com.atestados.online.AtestadosOnline.Models.SickNote;
import com.atestados.online.AtestadosOnline.Service.SickNoteService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/sicknotes")
@Api(tags = {"Atestados"})
public class SickNoteController {
	
	private SickNoteService sickNoteService;
	
	public SickNoteController(SickNoteService sns) {
		this.sickNoteService = sns;
	}
	
	@PostMapping
    public SickNote create(@Valid @RequestBody SickNote sickNote) {
		return sickNoteService.createOrUpdate(sickNote);
    }
	
	@GetMapping("")
    public ArrayList<SickNote> findAll() {
        return sickNoteService.findAll();
    }

    @GetMapping("/{sickNoteId}")
    public Optional<SickNote> findById(@PathVariable long sickNoteId) {
        return sickNoteService.findById(sickNoteId);
    }

    @PutMapping("/{sickNoteId}")
    public SickNote update(@PathVariable long sickNoteId, @Valid @RequestBody SickNote SickNote) {
        return sickNoteService.createOrUpdate(SickNote);
    }

    @DeleteMapping("/{sickNoteId}")
    public void deleteById(@PathVariable long sickNoteId) {
    	sickNoteService.deleteById(sickNoteId);
    }

}
