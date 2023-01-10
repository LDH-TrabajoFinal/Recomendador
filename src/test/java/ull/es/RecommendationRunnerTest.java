package ull.es;

import ull.es.RecommendationRunner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.jetbrains.annotations.TestOnly;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class RecommendationRunnerTest {
		
	@DisplayName("RecommendationRunner Testing")
	@Nested
	public class RecommendationRunnerTest1 {

		@DisplayName("Test if there is movies to rate")
		@org.junit.jupiter.api.Test
		public void test() {
			RecommendationRunner recomendation = new RecommendationRunner();
			recomendation.getItemsToRate();
			ArrayList<String> Item = recomendation.getItemsToRate();
				assertEquals(12, Item.size());
				assertEquals("1126590", recomendation.getItemsToRate().get(0));
				assertEquals("1179031", recomendation.getItemsToRate().get(1));
				assertEquals("1198156", recomendation.getItemsToRate().get(2));
				assertEquals("1216491", recomendation.getItemsToRate().get(3));
		}
	}
	
	@DisplayName("Test if getItemsToRate returns a list of movies")
    @Nested
   public class RecommendationRunner2 {
        @DisplayName("Test if getItemsToRate returns a list of movies")
        @org.junit.jupiter.api.Test
        public void test() {
            RecommendationRunner recommendationRunner = new RecommendationRunner();
            ArrayList<String> movies = recommendationRunner.getItemsToRate();
            	assertEquals(12, movies.size());
            	for (String movie : movies) {
                assertTrue(movie instanceof String);
            	}
        }
    }

	@DisplayName("Print Method works")
	@Nested
	public class PrintMethodTest {

		@DisplayName("Test if the print method works")
		@org.junit.jupiter.api.Test
		public void test() {
			RecommendationRunner recomendation = new RecommendationRunner();
			recomendation.printRecommendationsFor("1");
		}
	}

	@DisplayName("Test we cant pass a null value")
	@Nested
	public class NullValueTest {

		@DisplayName("Test if we cant pass a null value")
		@org.junit.jupiter.api.Test
		public void test() {
			RecommendationRunner recomendation = new RecommendationRunner();
			recomendation.printRecommendationsFor(null);
		}
	}
}
