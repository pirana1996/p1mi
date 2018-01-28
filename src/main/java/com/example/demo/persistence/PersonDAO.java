package com.example.demo.persistence;

import com.example.demo.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PersonDAO extends PagingAndSortingRepository<Person, Long> {

    Iterable<Person> findAll();

    Optional<Person> findByPersonId(int id);

}
