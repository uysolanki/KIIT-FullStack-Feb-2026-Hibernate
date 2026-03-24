package com.kiit.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ChieMinister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cmno;
	private String cmname;
	private int age;
}
