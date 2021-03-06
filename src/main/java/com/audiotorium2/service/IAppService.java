package com.audiotorium2.service;

import java.util.List;

import com.audiotorium2.core.*;
import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Item;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;


public interface IAppService {


	public void saveDecisionAnalysis(List<Product> products, List<Criteria> crts, List<Range> ranges);

	public EntityIssue saveIssue(EntityIssue issue);
	public EntityCriteria saveCriteria(EntityCriteria criteria);
	public EntityRange saveRange(EntityRange range);
	public EntityProduct saveProduct(EntityProduct product);
	public EntityProductDetails saveProductDetails(EntityProductDetails details);

	public void updateProduct(int productId, double grade , String name ,double price, int selected);
	public void updateIssue(int issue_id, int status);
	public List<EntityIssue> listUserIssues(int user_id);
	public List<EntityIssue> listIssuesByStatus(int status);

	public List<ProductView> listProducts(int issueid);
	public List<CriteriaRangeView> listProductDetail(int productid);
}
