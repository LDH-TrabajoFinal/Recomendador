package ull.es;

import java.util.*;
import org.apache.commons.csv.*;
import edu.duke.FileResource;

/**
 * @brief clase que representa un filtro para los generos
 * @author (Bryan Yen)
 * @version (2018-01-31)
 */
public class MovieDatabase {
    private static HashMap<String, Movie> ourMovies;

    /**
     * @brief Carga los datos de los ficheros de películas y de los actores
     */
    public static void initialize(String moviefile) {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("data/" + moviefile);
        }
    }

    /**
     * @brief Carga los datos de los ficheros de películas y de los actores
     */
    private static void initialize() {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("data/ratedmoviesfull.csv");
        }
    }

    /**
     * @brief Carga los datos de los ficheros de películas y de los actores
     * @param filename
     */
    private static void loadMovies(String filename) {
        FirstRatings fr = new FirstRatings();
        ArrayList<Movie> list = fr.loadMovies(filename);
        for (Movie m : list) {
            ourMovies.put(m.getID(), m);
        }
    }

    /**
     * @brief Devuelve el número de películas cargadas
     * @return
     */
    public static boolean containsID(String id) {
        initialize();
        return ourMovies.containsKey(id);
    }

    /**
     * @brief Devuelve el año de una película
     * @return
     */
    public static int getYear(String id) {
        initialize();
        return ourMovies.get(id).getYear();
    }

    /**
     * @brief Devuelve el genero de una película
     * @return
     */
    public static String getGenres(String id) {
        initialize();
        return ourMovies.get(id).getGenres();
    }

    /**
     * @brief Devuelve el título de una película
     * @return
     */
    public static String getTitle(String id) {
        initialize();
        return ourMovies.get(id).getTitle();
    }

    /**
     * @brief Devuelve una película
     * @return
     */
    public static Movie getMovie(String id) {
        initialize();
        return ourMovies.get(id);
    }

    /**
     * @brief Devuelve el poster de una película
     * @return
     */
    public static String getPoster(String id) {
        initialize();
        return ourMovies.get(id).getPoster();
    }

    /**
     * @brief Devuelve los minutos de una película
     * @return
     */
    public static int getMinutes(String id) {
        initialize();
        return ourMovies.get(id).getMinutes();
    }

    /**
     * @brief Devuelve el pais de una película
     * @return
     */
    public static String getCountry(String id) {
        initialize();
        return ourMovies.get(id).getCountry();
    }

    /**
     * @brief Devuelve el director de una película
     * @return
     */
    public static String getDirector(String id) {
        initialize();
        return ourMovies.get(id).getDirector();
    }

    /**
     * @brief Devuelve el número de películas cargadas
     * @return
     */
    public static int size() {
        return ourMovies.size();
    }

    /**
     * @brief Devuelve un ArrayList de todas las películas cargadas
     * @return
     */
    public static ArrayList<String> filterBy(Filter f) {
        initialize();
        ArrayList<String> list = new ArrayList<String>();
        for(String id : ourMovies.keySet()) {
            if (f.satisfies(id)) {
                list.add(id);
            }
        }
        
        return list;
    }

}
