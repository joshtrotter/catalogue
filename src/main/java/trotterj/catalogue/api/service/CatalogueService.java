/**
 * 
 */
package trotterj.catalogue.api.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import trotterj.catalogue.api.domain.Book;
import trotterj.catalogue.api.domain.Catalogue;
import trotterj.catalogue.api.domain.Movie;

/**
 * @author jtrotter
 *
 */
@Service
public class CatalogueService {
	
	private Catalogue<?> myMovies;
	private Catalogue<?> myBooks;
	
	public CatalogueService() {
		myMovies = initMovies();
		myBooks = initBooks();
	}
		
	public Catalogue<?> getMyMovies() {
		return myMovies;
	}

	public void setMyMovies(Catalogue<?> myMovies) {
		this.myMovies = myMovies;
	}

	public Catalogue<?> getMyBooks() {
		return myBooks;
	}

	public void setMyBooks(Catalogue<?> myBooks) {
		this.myBooks = myBooks;
	}

	private Catalogue<Book> initBooks() {
		Catalogue<Book> books = new Catalogue<Book>("My Books", Book.class);
		books.setItems(Arrays.asList(
				new Book("The Power of One", "Bryce Courtenay"), 
				new Book("One Flew Over the Cuckoo's Nest", "Ken Kesey"), 
				new Book("When the lion feeds", "Wilbur Smith")));
		return books;
	}

	private Catalogue<Movie> initMovies() {
		Catalogue<Movie> movies = new Catalogue<Movie>("My Movies", Movie.class);
		movies.setItems(Arrays.asList(
				new Movie("Pulp Fiction", "Quentin Tarantino"), 
				new Movie("Spartacus", "Stanley Kubrick"), 
				new Movie("Into the Wild", "Sean Penn")));
		return movies;
	}
	
}
