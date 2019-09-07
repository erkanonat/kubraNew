package com.audiotorium2.dao;

import com.audiotorium2.core.*;
import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;

import java.util.List;

public interface IAppDAO {

	public EntityIssue saveIssue(EntityIssue issue);
	public EntityCriteria saveCriteria(EntityCriteria criteria);
	public EntityRange saveRange(EntityRange range);
	public EntityProduct saveProduct(EntityProduct product);
	public EntityProductDetails saveProductDetails(EntityProductDetails details);

	public void updateProduct( int productId, double grade , String name ,double price, int selected);

	public List<EntityIssue> listIssuesByStatus(int status);
	public List<EntityIssue> listMyIssues(int userid);

	public List<ProductView> listProductsView(int issueid) ;
	public List<CriteriaRangeView> listProductDetail(int productId);
}
