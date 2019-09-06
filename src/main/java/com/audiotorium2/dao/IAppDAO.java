package com.audiotorium2.dao;

import com.audiotorium2.core.*;
import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;

public interface IAppDAO {

	public EntityIssue saveIssue(EntityIssue issue);
	public EntityCriteria saveCriteria(EntityCriteria criteria);
	public EntityRange saveRange(EntityRange range);
	public EntityProduct saveProduct(EntityProduct product);
	public EntityProductDetails saveProductDetails(EntityProductDetails details);

	
}
