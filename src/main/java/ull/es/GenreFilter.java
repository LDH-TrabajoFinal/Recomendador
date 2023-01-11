package ull.es;

/**
 * @brief clase que implementa el filtro para generos
 * @author (Bryan Yen)
 * @version (2018-01-31)
 */
public class GenreFilter implements Filter{
    private  String myGenre;

    public GenreFilter(String genre){
        myGenre = genre;
    }

    @Override
    public boolean satisfies(String id){
        return MovieDatabase.getGenres(id).contains(myGenre); 
    }
}