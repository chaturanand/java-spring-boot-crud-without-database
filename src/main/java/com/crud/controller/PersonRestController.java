package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Person;
import com.crud.service.IPersonService;

@RestController
@RequestMapping("/person/api/v1")
public class PersonRestController {

	@Autowired
	private IPersonService personService;

	@RequestMapping(path = "/people")
	public ResponseEntity<List<Person>> people() {
		List<Person> list = personService.listPerson();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/search/{name}")
	public ResponseEntity<List<Person>> search(@PathVariable(name = "name", required = true) String name) {
		List<Person> list = personService.search(name);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addperson")
	public ResponseEntity<Person> addEmployee(@RequestBody Person person) {
		personService.add(person);
		return new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editperson")
	public ResponseEntity<Person> editEmployee(@RequestBody Person person) {
		personService.edit(person);
		return new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/delete/{id}")
	public void delete(@PathVariable(name = "id") int id) {
		personService.delete(id);
		
	}
	

	
}
