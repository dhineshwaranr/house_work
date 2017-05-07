package com.house.work.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.github.dandelion.datatables.core.ajax.ColumnDef;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;

public class DandelionHelper {

public static Pageable buildPageable(final DatatablesCriterias datatablesCriterias) {
		
        Sort sort = buildSort(datatablesCriterias);
        
        int pageNumber = datatablesCriterias.getDisplayStart() / datatablesCriterias.getDisplaySize();
        return new PageRequest(pageNumber, datatablesCriterias.getDisplaySize(), sort);
    }

    private static Sort buildSort(final DatatablesCriterias datatablesCriterias) {
    	
        Sort sort = null;
        
    	try{
    		if (datatablesCriterias.getSortingColumnDefs().isEmpty()) {
            	
                List<Sort.Order> orders = new ArrayList<>();
                for (ColumnDef columnDef : datatablesCriterias.getSortingColumnDefs()) {
                    Sort.Order order = new Sort.Order(Sort.Direction.fromString(columnDef.getSortDirection().toString()), columnDef.getName());
                    orders.add(order);
                }
                sort = new Sort(orders);
            }
    	}catch(Exception e){
    		System.out.println(e);
    	}
        
        return sort;
    }
	
}
