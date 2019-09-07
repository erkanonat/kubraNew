package com.audiotorium2.service;

import java.util.ArrayList;
import java.util.List;

import com.audiotorium2.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audiotorium2.dao.IAppDAO;
import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Item;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;

@Service
public class AppServiceImp implements IAppService {

	@Autowired
	IAppDAO dao;

	@Override
	public EntityIssue saveIssue(EntityIssue issue) {
		return  dao.saveIssue(issue);
	}

	@Override
	public EntityCriteria saveCriteria(EntityCriteria criteria) {
		return dao.saveCriteria(criteria);
	}

	@Override
	public EntityRange saveRange(EntityRange range) {
		return dao.saveRange(range);
	}

	@Override
	public EntityProduct saveProduct(EntityProduct product) {
		return dao.saveProduct(product);
	}

	@Override
	public EntityProductDetails saveProductDetails(EntityProductDetails details) {
		return dao.saveProductDetails(details);
	}

	@Override
	public void updateProduct(int productId, double grade, String name, double price, int selected) {
			dao.updateProduct(productId, grade, name, price, selected);
	}

	@Override
	public List<EntityIssue> listUserIssues(int user_id) {
		return dao.listMyIssues(user_id);
	}

	@Override
	public List<EntityIssue> listIssuesByStatus(int status) {
		return dao.listIssuesByStatus(status);
	}

	@Override
	public List<ProductView> listProducts(int issueid) {
		return dao.listProductsView(issueid);
	}

	@Override
	public List<CriteriaRangeView> listProductDetail(int productid) {
		return dao.listProductDetail(productid);
	}

	public void saveDecisionAnalysis(List<Product> products, List<Criteria> crts, List<Range> ranges) {

	}

	@Override
	public void updateIssue(int issue_id, int status) {
		dao.updateIssue(issue_id,status);
	}

}
