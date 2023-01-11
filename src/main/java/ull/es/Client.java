package ull.es;

/**
 * @brief clase que ejecuta el recomendador de peliculas
 * @author (Ángel Capote)
 * @author (Diego Díaz)
 * @author (Jorge Domínguez)
 * @version (2018-01-31)
 */
public class Client {

    public static void main(String[] args) {
        RecommendationRunner n = new RecommendationRunner();

        System.out.println(n.getItemsToRate());


        n.printRecommendationsFor("1");

        System.out.println("\n\n\nhola mundo\n\n\n");
    }
}
