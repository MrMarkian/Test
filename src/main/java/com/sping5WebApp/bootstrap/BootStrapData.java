package com.sping5WebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sping5WebApp.domain.Author;
import com.sping5WebApp.domain.Book;
import com.sping5WebApp.domain.Publisher;
import com.sping5WebApp.repositories.AuthorRepository;
import com.sping5WebApp.repositories.BookRepoository;
import com.sping5WebApp.repositories.PublisherRepository;


@Component //Registers the class as a Spring Bean
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepoository bookRepository;
	
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepoository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override 
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setCity("St Petersburg");
		publisher.setState("FL");
		
		publisherRepository.save(publisher);
		
		Author eric = new Author("Eric", "Eve");
		Book ddd = new Book("Domain Driven Design", "122345445");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "393945646");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
		
		
		System.out.println("Started in Bootstrap");
		System.out.println();
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Publisher Count:"+ publisherRepository.count());
		System.out.println("Publisher Number of Books: " + publisher.getBooks().size() );
		
	}

}
