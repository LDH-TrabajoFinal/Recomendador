package ull.es;

import java.util.*;

public class ThirdRatings {
  
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    
    public ThirdRatings(String ratingsfile){
        //create a FirsrRatings object
        FirstRatings fr = new FirstRatings();
        // call the loadRaters
        myRaters = fr.loadRaters(ratingsfile);
    }
    
    /**
     * @return the number of raters
     */
    public int getRaterSize(){
        return myRaters.size();
    }

    /**
     * @return the average rating for this ID if there are at least minimalRaters ratings
     * @param id
     * @param minimalRaters
     * @return
     */
    private double getAverageByID(String id,int minimalRaters){
        double average =0;
        double total=0;
        int countRaters= 0;
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
     * @param minimalRaters
     * @return an ArrayList of all the Rating objects for movies that have at least the minimal number of raters supplying a rating
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
     * @param minimalRaters
     * @param filterCriteria
     * @return an ArrayList of all the Rating objects for movies that have at least the minimal number of raters supplying a rating and satisfies the filter criteria
     */
    public ArrayList<Rating>  getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria)
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
 
}
