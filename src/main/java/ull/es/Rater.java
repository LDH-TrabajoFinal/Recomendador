package ull.es;

import java.util.*;

/**
 * @brief clase que implementa la interfaz Rater
 * @details esta clase implementa la interfaz Rater
 * @author
 * 
 */
public interface Rater{
	public void addRating(String item, double rating);
	public boolean hasRating(String item);
	public String getID();
	public double getRating(String item);
	public int numRatings();
	public ArrayList<String> getItemsRated();

}