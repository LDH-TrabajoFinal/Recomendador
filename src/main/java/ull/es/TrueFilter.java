package ull.es;

/**
 * @brief clase que representa un filtro
 */
public class TrueFilter implements Filter {
	@Override
	public boolean satisfies(String id) {
		return true;
	}

}
