package ull.es;

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

/**
 * @brief clase que clasifica los datos de un fichero csv
 * @details esta clase clasifica los datos de un fichero csv y los guarda en un ArrayList
 * @author
 */

public class FirstRatings {
    /**
     * This method loads a list of movies from the file specified by the
     * @param filename
     * @return
     */
    public ArrayList<Movie> loadMovies(String filename){
        // procesa cada registro del fichero csv
        FileResource fr = new FileResource(filename);
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        for(CSVRecord record:fr.getCSVParser()){
            Movie currMovie = new Movie(record.get("id"),record.get("title"),record.get("year"),record.get("genre"),record.get("director"),record.get("country"),record.get("poster"),Integer.parseInt(record.get("minutes")));;
            movieList.add(currMovie);
        }
       
        return movieList;
    }

    /**
     * This method loads a list of raters from the file specified by the
     * @param filename
     * @return
     */
    public ArrayList<Rater> loadRaters(String filename){
        FileResource fr = new FileResource(filename);
        String searchRaterID = "2";
        ArrayList<Rater> raters = new ArrayList<Rater>();
        ArrayList<String> raterIDList = new ArrayList();
        // find the number of ratings for a particular rater
        
        for(CSVRecord record:fr.getCSVParser()){
            String rater_id = record.get("rater_id");
            String movie_id = record.get("movie_id");
            double rating = Double.parseDouble(record.get("rating"));
            
            if(raterIDList.contains(rater_id)==true){
                for(int k=0; k<raters.size();k++){
                    Rater currRater = raters.get(k);
                    if(currRater.getID().equals(rater_id)){
                        currRater.addRating(movie_id, rating);
                        raters.set(k, currRater);
                    } 
                }

            }

            else{
                Rater newRater = new EfficientRater(rater_id);
                newRater.addRating(movie_id, rating);
                raters.add(newRater);
                raterIDList.add(rater_id);
            }
        }
        return raters; 
    }

    /**
     * This method returns the number of movies in the ArrayList of type Movie
     * @param movieList
     * @return
     */
    public void testLoadRaters(){
        // print the total number of raters
        //ArrayList<Rater> loadedRaters = loadRaters("data/ratings_short.csv");
        ArrayList<Rater> loadedRaters = loadRaters("data/ratings.csv");
        
        // find the number of ratings for a particular rater
   
        System.out.println("loadedRaters size: " + loadedRaters.size());
        int numOfRatingsPerRater = getRatingsPerRater(loadedRaters, "193");
        System.out.println("rater_id:193 has " + numOfRatingsPerRater + " ratings");

      
        ////// Find maximum number of ratings /////////////////
        HashMap<String,Integer> raterWithNumOfMovies= new HashMap<String,Integer>();
        getRaterWithNumOfMovies(loadedRaters,raterWithNumOfMovies);
        
        int maxValue = Collections.max(raterWithNumOfMovies.values());
        String maxKey = "";
        for(String s:raterWithNumOfMovies.keySet()){
            if(raterWithNumOfMovies.get(s)==maxValue){
                maxKey = s;
            }
        }
        System.out.println("maxKey: "+ maxKey+ ", "+"maxValue: "+ maxValue);
        
        
       // Find maximum number of ratings
        int numOfRatingPerMovie= getNumOfRatingPerMovie(loadedRaters, "1798709");
        System.out.println("1798709 has " + numOfRatingPerMovie + " raters");
        
        // how many different movies have been rated by all these raters
         
        HashMap<String, Integer> movieRatingCounts = new HashMap();

        for(int k=0;k<loadedRaters.size();k++){
            Rater currRater = loadedRaters.get(k);
            for(int i=0;i< currRater.numRatings();i++){

                String currMovieID = currRater.getItemsRated().get(i);

                if(movieRatingCounts.containsKey(currMovieID)){
                    movieRatingCounts.put(currMovieID, movieRatingCounts.get(currMovieID)+1);
                }
                else{
                    movieRatingCounts.put(currMovieID, 1);
                }
            }
        }
        
        System.out.println("number of movies rated: " + movieRatingCounts.size());
        
    }
    
    /**
     * This method returns the number of ratings for a particular rater
     * @param loadedRaters
     * @param searchRaterID
     * @return
     */
    public int getRatingsPerRater(ArrayList<Rater> raters,String rater_id){
        int numOfRatingsPerRater=0;
        for(Rater currRater:raters){
            if(currRater.getID().equals(rater_id)){
               numOfRatingsPerRater +=1;
            }
        }
        return numOfRatingsPerRater;
    }
    
    /**
     * This method returns the number of ratings for a particular movie
     * @param loadedRaters
     * @param searchRaterID
     * @return
     */
    public void getRaterWithNumOfMovies(ArrayList<Rater> raters,HashMap<String,Integer> raterWithNumOfMovies){
        for(Rater rater:raters){
            if(!raterWithNumOfMovies.containsKey(rater.getID())){
                raterWithNumOfMovies.put(rater.getID(),1);
            }
            else{
                int num = raterWithNumOfMovies.get(rater.getID());
                num+=1;
                raterWithNumOfMovies.put(rater.getID(),num);
            }
        }
    }
    
    /**
     * This method returns the number of ratings for a particular movie
     * @param loadedRaters
     * @param searchRaterID
     * @return
     */
    public int getNumOfRatingPerMovie(ArrayList<Rater> raters,String movie_id){
        int numOfRatingPerMovie=0;
        for(Rater rater:raters){
            // use method hasRating in class Rater
            if(rater.hasRating(movie_id)){
                numOfRatingPerMovie+=1;
            }
        }
        return numOfRatingPerMovie;
    }
    
    
  }
    
    
