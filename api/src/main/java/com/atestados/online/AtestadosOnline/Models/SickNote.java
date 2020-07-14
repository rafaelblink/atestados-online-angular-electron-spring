package com.atestados.online.AtestadosOnline.Models;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "SickNotes")
public class SickNote {
	
	public static final String PK = "sicknote_id";
	
	@Id
    @GeneratedValue
    @Column(name = PK)
    private Long id;
	

	@Column(nullable=false)	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate date;
	
	@Column(nullable=false)
	private Integer days_rest;
	
	@Column(nullable=false)	

	private String start_time;
	
	@Column(nullable=false)	
	private String end_time;	
	
	@Size(max=7)
	@Column(nullable=true, length=7)
	private String CID;
	
	@Size(max=500)
	@Column(nullable=true, length=500)
	private String details;
	
 	@ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
 	
 	@ManyToOne
    @JoinColumn(name = "inpatient_id")
    private Inpatient inpatient;
	

}