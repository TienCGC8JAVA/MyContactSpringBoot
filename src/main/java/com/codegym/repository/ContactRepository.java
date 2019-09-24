package com.codegym.repository;

import com.codegym.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

  List<Contact> findByNameContaining(String term);

  Optional<Contact> findById(Integer id);
}
