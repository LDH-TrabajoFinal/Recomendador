package ull.es;

import java.util.ArrayList;

/**
 * @brief clase que guarda una lista de filtros
 * @details esta clase guarda una lista de filtros y los aplica a un id
 * @author
 * 
 */
public class AllFilters implements Filter {
    ArrayList<Filter> filters;
    
    public AllFilters() {
        filters = new ArrayList<Filter>();
    }

    public void addFilter(Filter f) {
        filters.add(f);
    }

    @Override
    public boolean satisfies(String id) {
        for(Filter f : filters) {
            if (! f.satisfies(id)) {
                return false;
            }
        }
        
        return true;
    }

}
