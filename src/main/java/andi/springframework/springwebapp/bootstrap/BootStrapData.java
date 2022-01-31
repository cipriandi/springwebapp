package andi.springframework.springwebapp.bootstrap;

import andi.springframework.springwebapp.domain.Author;
import andi.springframework.springwebapp.domain.Book;
import andi.springframework.springwebapp.domain.Publisher;
import andi.springframework.springwebapp.repositories.AuthorRepository;
import andi.springframework.springwebapp.repositories.BookRepository;
import andi.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans" );
        Book book = new Book("Domain Driven Design", "12341234");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod = new Author("Rod", "Johnson" );
        Book noEJB = new Book("J2EE Dev", "87545454");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher("Address of the publisher", "New York",
                "California", "54856");

        publisherRepository.save(publisher);

        System.out.println("Started");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("We have the following publisher available" + publisherRepository);
    }
}
