package com.example.algamoney.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney.api.repository.PeopleRepository;

@RestController
@RequestMapping("/people")
public class PersonResource {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@GetMapping
	public List<com.example.algamoney.api.model.Person> list() {
		return peopleRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<com.example.algamoney.api.model.Person> create(@Valid @RequestBody com.example.algamoney.api.model.Person person, HttpServletResponse response) {
		
		com.example.algamoney.api.model.Person personSaved = peopleRepository.save(person);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(personSaved.getId()).toUri();
		 
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(personSaved);
	}

	//	@GetMapping("/{id}")
//	public Optional<com.example.algamoney.api.model.Person> findById(@PathVariable Long id) {
//		return peopleRepository.findById(id);
//	}
//	
	@GetMapping("/{id}")
	public Optional<Object> findById(@PathVariable Long id) {
		return Optional.of(peopleRepository.findById(id).map(cat -> ResponseEntity.ok(cat)).orElse(ResponseEntity.notFound().build()));
	}


}
