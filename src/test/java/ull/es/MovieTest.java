package ull.es;

import ull.es.Movie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovieTest {

	@Test
	void testGetID() {
		Movie movie = new Movie("0453345", "Cars", "2003", "Cars, Action", "USA", "Steven", "A", 2003);
		assertEquals("0453345", movie.getID());

	}

	@Test
	void testGetTitle() {
		Movie movie = new Movie("0453345", "Cars", "2003", "Cars, Action", "USA", "Steven", "A", 2003);
		assertEquals("Cars", movie.getTitle());
	}

	@Test
	void testGetGenres() {
		Movie movie = new Movie("0453345", "Cars", "2003", "Cars, Action", "USA", "Steven", "A", 2003);
		assertEquals("Cars, Action", movie.getGenres());
	}

	@Test
	void testGetCountry() {
		Movie movie = new Movie("0453345", "Cars", "2003", "Cars, Action", "USA", "Steven", "A", 2003);
		assertEquals("Steven", movie.getCountry());
	}

	@Test
	void testGetDirector() {
		Movie movie = new Movie("0453345", "Cars", "2003", "Cars, Action", "USA", "Steven", "A", 2003);
		assertEquals("USA", movie.getDirector());
	}

	@Test
	void testGetPoster() {
		Movie movie = new Movie("0453345", "Cars", "2003", "Cars, Action", "USA", "Steven", "A", 2003);
		assertEquals("A", movie.getPoster());
	}

	@Test
	void testGetMinutes() {
		Movie movie = new Movie("0453345", "Cars", "2003", "Cars, Action", "USA", "Steven", "A", 2003);
		assertEquals(2003, movie.getMinutes());
		
	}

}
