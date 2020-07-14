package com.atestados.online.AtestadosOnline.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atestados.online.AtestadosOnline.Models.SickNote;

@Repository
public interface SickNoteRepository extends CrudRepository<SickNote, Long>{

}