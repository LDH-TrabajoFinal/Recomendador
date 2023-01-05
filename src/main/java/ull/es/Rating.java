package ull.es;


public class Rating implements Comparable<Rating> {
    private String item;
    private double value;

    public Rating (String anItem, double aValue) {
        item = anItem;
        value = aValue;
    }

    /**
     * @return the item
     */
    public String getItem () {
        return item;
    }

   /**
     * @return the value of this rating (as a number so it can be used in calculations)
     */
    public double getValue () {
        return value;
    }

    /**
     * @param item the item to set
     * @return string of all the rating information
     */
    public String toString () {
        return "[" + getItem() + ", " + getValue() + "]";
    }


    /**
     * @param other rating que comparar
     * @return 0 if the ratings are equal, -1 if this rating is less than the
     * parameter rating, 1 if this rating is greater than the parameter rating
     */
    public int compareTo(Rating other) {
        if (value < other.value) return -1;
        if (value > other.value) return 1;
        
        return 0;
    }
}
