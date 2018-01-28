package com.example.demo.persistence;

import com.example.demo.model.Person;
import com.example.demo.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PersonDAO extends PagingAndSortingRepository<Person, Long> {

    Iterable<Person> findAll();

    Optional<Person> findByPersonId(int id);

}
