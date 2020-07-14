package com.atestados.online.AtestadosOnline.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Doctors")
public class Doctor {
	
	public static final String PK = "doctor_id";
	
	
	@Id
    @GeneratedValue
    @Column(name = PK)
    private Long id;
	
	@NotBlank
	@Size(max=100)
	@Column(nullable=false, length=100)
	private String name;
	
	@NotBlank
	@Size(max=13)
	@Column(nullable=false, length=13)
	private String CRM;	
	
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
	private List<SickNote> sicknotes;

}
