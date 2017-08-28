package com.matmatch.rest.service;

import com.matmatch.rest.repository.PersonRepository;
import com.matmatch.rest.repository.search.PersonSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;


@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonSearchRepository personSearchRepository;

    @Autowired
    private PersonRepository personRepository;


    @PostConstruct
    public void reindex() {
        personSearchRepository.save(personRepository.findAll());
    }
}
