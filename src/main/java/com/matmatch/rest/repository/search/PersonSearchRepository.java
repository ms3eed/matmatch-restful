package com.matmatch.rest.repository.search;

import com.matmatch.rest.domain.Person;
import com.matmatch.rest.domain.enumeration.Gender;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Spring Data Elasticsearch repository for the Person entity.
 */
public interface PersonSearchRepository extends ElasticsearchRepository<Person, Long> {

    List<Person> findByFirstNameLikeAndGender(String firstName, Gender gender);
}
