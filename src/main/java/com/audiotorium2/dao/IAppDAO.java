package com.audiotorium2.dao;

import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;

public interface IAppDAO {

	public String saveProduct(Product p);
	public String saveCriteria(Criteria c);
	public String saveRange(Range r);
	
}
