package ull.es;

/**
 * @brief clase que implementa el filtro para el numero de minutos
 * @author (Bryan Yen)
 * @version (2018-01-31)
 */
public class MinutesFilter implements Filter{
	private int myMinMinutes;
	private int myMaxMinutes;

	public MinutesFilter(int minMinutes,int maxMinutes){
		myMinMinutes = minMinutes;
		myMaxMinutes = maxMinutes;
	}

	@Override
	public boolean satisfies(String id){
		int time =MovieDatabase.getMinutes(id);
		if(time >= myMinMinutes && time <= myMaxMinutes){
			return true;
		}

		else{
			return false;
		}
	}
}