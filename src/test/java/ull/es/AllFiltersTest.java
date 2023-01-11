package ull.es;

import ull.es.AllFilters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AllFiltersTest {

	@Test
	void testAllFilters() {
	}

	@Test
	void testAddFilter() {
		AllFilters allFilters = new AllFilters();
		allFilters.addFilter(new AllFilters());
		assertEquals(1, allFilters.filters.size());
	}

	@Test
	void testSatisfies() {
		assertEquals(true, new AllFilters().satisfies("1"));
	}

	@Test
	void testToString() {
		assertEquals("ull.es.AllFilters@dcc6211", new AllFilters().toString());
	}

}
