package andi.springframework.springwebapp.repositories;

import andi.springframework.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
