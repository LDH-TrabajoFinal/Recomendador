package ull.es;

/**
 * @brief clase pelicula
 * @author (Bryan Yen)
 * @version (2018-01-31)
 */
public class Movie {
    private String id;
    private String title;
    private int year;
    private String genres;
    private String director;
    private String country;
    private String poster;
    private int minutes;

    public Movie (String anID, String aTitle, String aYear, String theGenres) {
        // just in case data file contains extra whitespace
        id = anID.trim();
        title = aTitle.trim();
        year = Integer.parseInt(aYear.trim());
        genres = theGenres;
    }

    public Movie (String anID, String aTitle, String aYear, String theGenres, String aDirector,
    String aCountry, String aPoster, int theMinutes) {
        // just in case data file contains extra whitespace
        id = anID.trim();
        title = aTitle.trim();
        year = Integer.parseInt(aYear.trim());
        genres = theGenres;
        director = aDirector;
        country = aCountry;
        poster = aPoster;
        minutes = theMinutes;
    }

    /**
     * @return the id
     */
    public String getID () {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle () {
        return title;
    }

    /**
     * @return the year
     */
    public int getYear () {
        return year;
    }

    /**
     * @return the genres
     */
    public String getGenres () {
        return genres;
    }

    /**
     * @return the country
     */
    public String getCountry(){
        return country;
    }

    /**
     * @return the director
     */
    public String getDirector(){
        return director;
    }

    /**
     * @return the poster
     */
    public String getPoster(){
        return poster;
    }

    /**
     * @return the minutes
     */
    public int getMinutes(){
        return minutes;
    }

    /**
     * @return the movie info
     */
    public String toString () {
        String result = "Movie [id=" + id + ", title=" + title + ", year=" + year;
        result += ", genres= " + genres + "]";
        return result;
    }
}
