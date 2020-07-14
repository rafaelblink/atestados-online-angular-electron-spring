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
@Setter
@Getter
@Table(name = "Inpatients")
public class Inpatient {
	
	public static final String PK = "inpatient_id";
	
	@Id
    @GeneratedValue
    @Column(name = PK)
    private Long id;
	
	@NotBlank
	@Size(max=100)
	@Column(nullable=false, length=100)
	private String name;
	
	@NotBlank
	@Size(max=7)
	@Column(nullable=false, length=7)
	private String RG;

	@OneToMany(mappedBy = "inpatient")
	@JsonIgnore
	private List<SickNote> sicknotes;

}