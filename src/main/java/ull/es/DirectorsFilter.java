package ull.es;

import java.util.*;

/**
 * @brief clase que implementa el filtro para directores
 * @author (Bryan Yen)
 * @version (2018-01-31)
 */
public  class DirectorsFilter implements Filter{
	private String myDirectors;

	public DirectorsFilter(String directors){
		myDirectors = directors;
	}

	@Override
	public boolean satisfies(String id){
		ArrayList<String> dirList= new ArrayList(Arrays.asList(myDirectors.split(",")));
		for(String dir:dirList){
			if(MovieDatabase.getDirector(id).contains(dir)){
				return true;
			}
		}
		return false;
	}
}