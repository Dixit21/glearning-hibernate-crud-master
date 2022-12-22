package com.glearning.hibernate.crud.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
	private Set<Subject> subjects;
	private String name;
	private int grade;
	
	Student() {}
	
	//setters and getters
	//toString, equals, hashocde
	
	

}
