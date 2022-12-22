package ull.es;

public class Client {

    public static void main(String[] args) {
        RecommendationRunner n = new RecommendationRunner();

        System.out.println(n.getItemsToRate());


        n.printRecommendationsFor("1");

        System.out.println("\n\n\nhola mundo\n\n\n");
    }
}
