package ull.es;

/**
 * @brief Clase abstracta que representa un filtro
 * @author (Bryan Yen)
 * @version (2018-01-31)
 */
public interface Filter {
	public boolean satisfies(String id);
}
