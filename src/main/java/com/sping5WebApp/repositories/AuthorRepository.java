package com.sping5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sping5WebApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
