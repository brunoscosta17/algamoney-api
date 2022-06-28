package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.algamoney.api.model.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {
    
}