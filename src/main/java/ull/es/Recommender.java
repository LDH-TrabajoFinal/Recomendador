package ull.es;

import java.util.*;

/**
 * Cuando los usuarios visitan por primera vez el sitio web del recomendador,
 * nuestro código llamará al método getItemsToRate () para obtener una lista de
 * películas para mostrar en la página web para que los usuarios califiquen.
 *
 * Cuando un usuario envía sus calificaciones, nuestro código llamará al método
 * printRecommendationsFor para obtener sus recomendaciones basadas en las
 * calificaciones del usuario. El ID que se le da a este método es para un nuevo
 * Rater que ya hemos agregado a la RaterDatabase con calificaciones para las
 * películas devueltas por el primer método. Lo que se imprima desde ese método
 * se mostrará en la página web: HTML, texto sin formato o información de
 * depuración.
 */

public interface Recommender {
    /**
     * Este método devuelve una lista de identificadores de películas que se
     * utilizarán para buscar las películas en la MovieDatabase y presentarlas
     * a los usuarios para que las califiquen.
     *
     * Las películas devueltas en la lista se mostrarán en una página web, por
     * lo que el número que elija puede afectar el tiempo que tarda en cargar la
     * página y la disposición de los usuarios a calificar las películas. Por
     * ejemplo, 10-20 debería estar bien, 50 o más serían demasiados.
     *
     * No hay restricciones en el método que utilice para generar esta lista de
     * películas: las películas más recientes, películas de un género específico,
     * películas elegidas al azar o simplemente sus películas favoritas.
     *
     * Las calificaciones de estas películas harán el perfil de un nuevo Rater
     * que se utilizará para comparar para encontrar recomendaciones.
     */
    public ArrayList<String> getItemsToRate ();

    /**
     * Este método no devuelve nada, pero imprime una tabla HTML de las películas
     * recomendadas para el rater dado.
     *
     * El HTML impreso se mostrará en una página web, por lo que el número que
     * elija para mostrar puede afectar el tiempo que tarda en cargar la página.
     * Por ejemplo, es posible que desee limitar el número impreso solo a las
     * 20-50 mejores películas recomendadas o a películas no calificadas por el
     * rater dado.
     *
     * También puede incluir estilos CSS para su tabla utilizando la etiqueta
     * &lt;style&gt; antes de imprimir la tabla. No hay restricciones sobre qué
     * películas imprime, en qué orden las imprime o qué información incluye
     * sobre cada película.
     *
     * @param webRaterID el ID de un nuevo Rater que ya se ha agregado a la
     *        RaterDatabase con calificaciones para las películas devueltas por el
     *        método getItemsToRate
     */
    public void printRecommendationsFor (String webRaterID);
}
