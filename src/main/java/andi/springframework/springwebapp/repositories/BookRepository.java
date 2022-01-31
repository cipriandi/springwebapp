package andi.springframework.springwebapp.repositories;

import andi.springframework.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
