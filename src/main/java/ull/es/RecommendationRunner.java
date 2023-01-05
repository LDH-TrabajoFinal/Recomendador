package ull.es;

import java.util.*;



public class RecommendationRunner implements Recommender {
    /**
     * @return lista de peliculas para recomendar
     */
	public ArrayList<String> getItemsToRate(){
		ArrayList<String> moviesToRate = new ArrayList<String>();

		String [] movies ={"1126590","1179031","1198156","1216491",
							"1361318","1408253","1430612","1441953",
							"1490017","1528100","1571249","1600196"};
		for(int i=0;i<12;i++){
			moviesToRate.add(movies[i]);
		}
		return moviesToRate;
	}

    /**
     * @brief imprime por pantalla recomendaciones de peliculas para un usuario
     * @param webRaterID id de la web que hace la recomendacion
     */
	public void printRecommendationsFor(String webRaterID){
		FourthRatings fr = new FourthRatings();
		int numSimilarRaters = 5;
		int minimalRaters = 3 ;

		ArrayList<Rating> recList = fr.getSimilarRatings(webRaterID,numSimilarRaters,minimalRaters);
		
		if(recList.size()==0){
			printError();
		}

		else{
			printUpperPart();
             int i=0;
             for(Rating r: recList){
                 i++;
                 if((i+1)%2 == 0){
                 	System.out.println("<tr class=\"even_rows\"><td>" + i + "</td>");
                 }
                 else{
                 	System.out.println("<tr class=\"odd_rows\"><td>" + i + "</td>");
                 }

                 String URL = MovieDatabase.getPoster(r.getItem());
                 String title = MovieDatabase.getTitle(r.getItem());
                 String director = MovieDatabase.getDirector(r.getItem());
                 String country = MovieDatabase.getCountry(r.getItem());
                 int year = MovieDatabase.getYear(r.getItem());
                 String genre = MovieDatabase.getGenres(r.getItem());
                 int minutes = MovieDatabase.getMinutes(r.getItem());

                 System.out.println("<td><table><tr><td class = \"pic\">");

                 if(URL.length()>3){
                 	System.out.println("<img src = \""+URL+"\" target=_blank></td>");
                 }
                  
                 System.out.println("<td><h3>"+ title+"</h3>");
                 System.out.println("<b>by "+ genre+"</b><br>");
                 System.out.println(year+"<br>");
                 System.out.println(country+"<br>");
                 System.out.println(minutes+" minutes</td></tr></table></td></tr>");
                 if(i>12) break;
             }
             printLowerPart();

		}
	}

    /**
     * @brief imprime por pantalla un mensaje de error
     */
	private void printError(){
		System.out.println("This is system error, please try again!");
	}

    /**
    * @brief imprime por pantalla la parte superior de la pagina web
    */
  	private void printUpperPart(){
        System.out.println("<link href=\"https://fonts.googleapis.com/css?family=Syncopate\" rel=\"stylesheet\"><link href=\"https://fonts.googleapis.com/css?family=Roboto|Syncopate\" rel=\"stylesheet\"><div id=\"header\"><h2>Recommended Movies:</h2></div><table class=\"outside_table\"><tr  class=\"table-header\"><th>&nbsp</th><th class=\"movie_title\">Title</th></tr>");
     }

    /**
     * @brief imprime por pantalla la parte inferior de la pagina web
     */
    private void printLowerPart(){
        System.out.println("</table>");
    }
}