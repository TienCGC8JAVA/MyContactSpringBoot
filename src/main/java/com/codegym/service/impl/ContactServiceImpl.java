package com.codegym.service.impl;

import com.codegym.entity.Contact;
import com.codegym.repository.ContactRepository;
import com.codegym.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

  @Autowired
  private ContactRepository contactRepository;

  @Override
  public Iterable<Contact> findAll() {
    return contactRepository.findAll();
  }

  @Override
  public List<Contact> search(String term) {
    return contactRepository.findByNameContaining(term);
  }

  @Override
  public Optional<Contact> findById(Integer id) {
    return contactRepository.findById(id);
  }

  @Override
  public void save(Contact contact) {
    contactRepository.save(contact);
  }

  @Override
  public void delete(Integer id) {
    contactRepository.deleteById(id);
  }


}
