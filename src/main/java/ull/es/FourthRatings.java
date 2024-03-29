package ull.es;

import java.util.*;

/**
 * @brief FourthRatings class that calculates the average rating of a movie
 * @details This class calculates the average rating of a movie and returns an
 * @author
 * 
 */

public class FourthRatings {
	/**
	 * This method returns a double representing the average movie rating for this ID
	 * if there are at least minimalRaters ratings. If there are not minimalRaters
	 * ratings, then it returns 0.0.
	 *
	 * @param movieID
	 * @param minimalRaters
	 * @return
	 */
	private double getAverageByID(String id,int minimalRaters){
        double average =0;
        double total=0;
        int countRaters= 0;

        ArrayList<Rater> myRaters = RaterDatabase.getRaters();


        for(Rater rater:myRaters){
            if(rater.hasRating(id)){
                countRaters++;
                total = total + rater.getRating(id);
            }
        }
        
        if(countRaters >= minimalRaters){
            average = total/countRaters;
        }
        return average;
        
    }

	/**
	 * This method returns an ArrayList of all the Rating objects for movies that
	 * @param minimalRaters
	 * @return
	 */
	public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> avgRatingList = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String id:movies){
            double avg = getAverageByID(id,minimalRaters);
            if(avg>0.0){
                Rating currRating = new Rating(id,avg);
                avgRatingList.add(currRating);
            }    
        }

        return avgRatingList;
    }

	/**
	 * This method returns an ArrayList of all the Rating objects for movies that
	 * @param minimalRaters
	 * @param filterCriteria
	 * @return
	 */
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria)
    {
        ArrayList<Rating> avgRatingListByFilter = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for(String id:movies){
            double avg = getAverageByID(id, minimalRaters);
            if(avg>0.0){
                Rating currRating = new Rating(id,avg);
                avgRatingListByFilter.add(currRating);
            }
        }
        return avgRatingListByFilter;

    }

	/**
	 * This method returns the dot product of two Rater objects
	 * @param me
	 * @param r
	 * @return
	 */
    private double dotProduct(Rater me,Rater r){
    	double similarValue=0;
    	ArrayList<String> itemsRatedByMe = me.getItemsRated();

    	for(String movieID:itemsRatedByMe){
    		if(r.hasRating(movieID)){
    			double rRating = r.getRating(movieID)-5;
    			double myRating = me.getRating(movieID)-5;

    			similarValue = similarValue + (rRating*myRating);
    		}
    	}
    	return similarValue;
    }

	/**
	 * This method returns an ArrayList of type Rating of all the raters and their
	 * @param id
	 * @return
	 */
    private  ArrayList<Rating> getSimilarities(String id){
    	ArrayList<Rating> list = new ArrayList<Rating>();
    	ArrayList<Rater> allRaters = RaterDatabase.getRaters();

    	// input id implied raterByMe
    	Rater me = RaterDatabase.getRater(id);

    	for(Rater r: allRaters){
    		String raterID = r.getID();
    		// add dot_product(r,me) to list if r !=me
    		if(raterID.equals(id)== false){
    			double similarValue = dotProduct(me,r);
    			Rating similarRating = new Rating(raterID,similarValue);
    			list.add(similarRating);
    		}

    	}
    	Collections.sort(list, Collections.reverseOrder());
    	return list;
    }

	/**
	 * This method returns an ArrayList of type Rating of all the raters and their
	 * @param id
	 * @param numSimilarRaters
	 * @param minimalRaters
	 * @return
	 */
	public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters){
        return getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, new TrueFilter());
    }

	/**
	 * This method returns an ArrayList of type Rating of all the raters and their
	 * @param id
	 * @param numSimilarRaters
	 * @param minimalRaters
	 * @param filterCriteria
	 * @return
	 */
	public ArrayList<Rating> getSimilarRatingsByFilter(String id,int numSimilarRaters, int minimalRaters, Filter filterCriteria){
		ArrayList<Rating> movieSimRatings = new ArrayList();
		ArrayList<Rating> raterSimList = getSimilarities(id);
		ArrayList<String> movieIDList = new ArrayList();

		HashMap<String,Double> similarMap = new HashMap();
		int mapSize = getSimilarities(id).size();
		int minIndex = Math.min(mapSize, numSimilarRaters);

		for(Rating similar:getSimilarities(id).subList(0,minIndex)){
			if(similar.getValue()>0){
				similarMap.put(similar.getItem(), similar.getValue());
			}
		}

		for(String movieID:MovieDatabase.filterBy(filterCriteria)){
			int count =0;
			double total =0;

			for(Rater curRater:RaterDatabase.getRaters()){
				double rating = -1;
				if(similarMap.containsKey(curRater.getID()) && curRater.hasRating(movieID)){
					rating = curRater.getRating(movieID) * similarMap.get(curRater.getID());
				}

				if(rating ==-1){}

				else{
					count++;
					total = total + rating;
				}
			}

			if(count< minimalRaters || total==0){}
			else{
				movieSimRatings.add(new Rating(movieID, total/count));
			}

		}
		Collections.sort(movieSimRatings, Collections.reverseOrder());
		return movieSimRatings;
	}
}
