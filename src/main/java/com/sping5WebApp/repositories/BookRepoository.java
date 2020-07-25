package com.sping5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.sping5WebApp.domain.Book;

public interface BookRepoository extends CrudRepository<Book, Long>{

}
