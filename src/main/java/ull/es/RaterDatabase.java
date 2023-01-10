package ull.es;

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

/**
 * @brief base de datos de raters
 * @author (Bryan Yen)
 * @version (2018-01-31)
 */
public class RaterDatabase {
	private static HashMap<String,Rater> ourRaters;
     
	private static void initialize() {
	    // this method is only called from addRatings 
		if (ourRaters == null) {
			ourRaters = new HashMap<String,Rater>();
		}
	}

    public static void initialize(String filename) {
 		if (ourRaters == null) {
 			ourRaters= new HashMap<String,Rater>();
 			addRatings("data/" + filename);
 		}
 	}

    /**
     * This method adds the ratings of a rater to the database
     * @param filename
     */
    public static void addRatings(String filename) {
        initialize(); 
        FileResource fr = new FileResource(filename);
        CSVParser csvp = fr.getCSVParser();
        for(CSVRecord rec : csvp) {
                String id = rec.get("rater_id");
                String item = rec.get("movie_id");
                String rating = rec.get("rating");
                addRaterRating(id,item,Double.parseDouble(rating));
        } 
    }

    /**
     * This method adds a rater to the database
     * @param raterID the ID of the rater
     * @param movieID the ID of the movie
     * @param rating the rating of the movie
     */
    public static void addRaterRating(String raterID, String movieID, double rating) {
        initialize(); 
        Rater rater =  null;
                if (ourRaters.containsKey(raterID)) {
                    rater = ourRaters.get(raterID); 
                } 
                else { 
                    rater = new EfficientRater(raterID);
                    ourRaters.put(raterID,rater);
                 }
                 rater.addRating(movieID,rating);
    } 

    /**
     * This method returns a rater given its ID
     * @param id the ID of the rater
     * @return the rater
     */
    public static Rater getRater(String id) {
    	initialize();
    	
    	return ourRaters.get(id);
    }

    /**
     * This method returns the list of raters
     * @return the list of raters
     */
    public static ArrayList<Rater> getRaters() {
    	initialize();
    	ArrayList<Rater> list = new ArrayList<Rater>(ourRaters.values());
    	
    	return list;
    }

    /**
     * This method returns the number of raters
     * @return
     */
    public static int size() {
	    return ourRaters.size();
    }
}
