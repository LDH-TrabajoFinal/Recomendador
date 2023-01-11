package ull.es;

import ull.es.EfficientRater;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class EfficientRaterTest {

	@Test
	void testEfficientRater() {
		EfficientRater efficientRaterTest = new EfficientRater("1");
		assertEquals("1", efficientRaterTest.getID());

	}

	@Test
	void testAddRating() {
		EfficientRater efficientRaterTest = new EfficientRater("1");
		efficientRaterTest.addRating("1", 1);
		efficientRaterTest.addRating("2", 2);
		assertEquals(1, efficientRaterTest.getRating("1"));
		assertEquals(2, efficientRaterTest.getRating("2"));
	}

	@Test
	void testHasRating() {
		EfficientRater efficientRaterTest = new EfficientRater("1");
		efficientRaterTest.addRating("1", 1);
		assertEquals(true, efficientRaterTest.hasRating("1"));
		assertEquals(false, efficientRaterTest.hasRating("1000"));
		
	}

	@Test
	void testGetID() {
		EfficientRater efficientRaterTest = new EfficientRater("1000");
		assertEquals("1000", efficientRaterTest.getID());
	}

	@Test
	void testGetRating() {
		EfficientRater efficientRaterTest = new EfficientRater("1");
		efficientRaterTest.addRating("1", 1);
		assertEquals(1, efficientRaterTest.getRating("1"));
	}

	@Test
	void testNumRatings() {
		EfficientRater efficientRaterTest = new EfficientRater("1");
		efficientRaterTest.addRating("1", 1);
		assertEquals(1, efficientRaterTest.numRatings());
	}

	@Test
	void testGetItemsRated() {
		EfficientRater efficientRaterTest = new EfficientRater("1");
		efficientRaterTest.addRating("1", 1);
		assertEquals(1, efficientRaterTest.getItemsRated().size());
	}

}
