package ull.es;

import java.util.*;
 /**
  * @brief interfaz que representa un rater
  * @author (Bryan Yen)
  * @version (2018-01-31)
  */
public interface Rater{
	public void addRating(String item, double rating);
	public boolean hasRating(String item);
	public String getID();
	public double getRating(String item);
	public int numRatings();
	public ArrayList<String> getItemsRated();

}