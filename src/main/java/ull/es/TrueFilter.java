package ull.es;

/**
 * @brief clase que representa un filtro
 * @author (Bryan Yen)
 * @version (2018-01-31)
 */
public class TrueFilter implements Filter {
	@Override
	public boolean satisfies(String id) {
		return true;
	}

}
