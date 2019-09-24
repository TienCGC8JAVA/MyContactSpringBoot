package com.codegym.service;

import com.codegym.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {

  Iterable<Contact> findAll();

  List<Contact> search(String term);

  Optional<Contact> findById(Integer id);

  void save(Contact contact);

  void delete(Integer id);
}
