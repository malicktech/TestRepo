package com.example.ex06;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonRepository personRepository;
	
	private Person person = new Person();

	public List<Person> getPersonList() {
		return personRepository.findAll();
	}

	public void savePerson() {
		personRepository.save(person);
		person = new Person();
	}

	public void deletePerson(Person person) {
		personRepository.delete(person);
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
}
