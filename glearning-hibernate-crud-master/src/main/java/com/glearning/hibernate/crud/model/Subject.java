package com.glearning.hibernate.crud.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	
	@ManyToMany
	//represents the owner of the bidirectional relationhip
	@JoinTable(
			name="students_subject",
			joinColumns = @JoinColumn(name="student_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name="subject_id", nullable=false)
			)
	private Set<Student> students;

	Subject() {
	}

	public Subject(String subject) {
		this.name = subject;
	}

	@ManyToOne
	// foreign key
	@JoinColumn(name = "teacher_id", nullable = false)
	private Teacher teacher;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}