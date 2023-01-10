package ull.es;

/**
 * @brief clase que implementa el filtro para el año
 * @author (Bryan Yen)
 * 		@version (2018-01-31)
 */
public class YearAfterFilter implements Filter {
	private int myYear;
	
	public YearAfterFilter(int year) {
		myYear = year;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getYear(id) >= myYear;
	}


}
