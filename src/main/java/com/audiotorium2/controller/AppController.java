package com.audiotorium2.controller;

import java.util.ArrayList;
import java.util.List;

import com.audiotorium2.core.*;
import com.audiotorium2.utility.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Item;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;
import com.audiotorium2.service.IAppService;

import javax.servlet.http.HttpSession;

@Controller
public class AppController {

	
	@Autowired
	IAppService appService;

	public List<ProductView> listProductsOfIssues( int issueId) {
		List<ProductView> result = new ArrayList<ProductView>();

		result = appService.listProducts(issueId);

		if(result!=null && result.size()>0) {
			for(int i=0;i<result.size();i++) {
				List<CriteriaRangeView> details = appService.listProductDetail(result.get(i).getProduct_id());
				result.get(i).setCriterias(details);
			}
		}

		return result;
	}

	public List<EntityIssue> listMyIssues(int userid) {
		return appService.listUserIssues(userid);
	}

	public List<EntityIssue> listIssuesByStatus(int status) {
		return appService.listIssuesByStatus(status);
	}

	public EntityIssue saveIssue(String name ) {
		try {
			EntityIssue issue = new EntityIssue();

			HttpSession session = SessionUtils.getSession();
			int userId = (Integer) session.getAttribute("id");

			issue.setIssue_name(name);
			issue.setUser_id(Integer.valueOf(userId));

			return appService.saveIssue(issue);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public EntityCriteria saveCriteria(int issue_id , String name, Double weight ) {

		try {
			EntityCriteria criteria = new EntityCriteria();

			criteria.setIssue_id(issue_id);
			criteria.setName(name);
			criteria.setWeight(weight);

			return appService.saveCriteria(criteria);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public EntityRange saveRange(int criteria_id, String range_name, double range_value ) {
		try {
			EntityRange range = new EntityRange();
			range.setCriteria_id(criteria_id);
			range.setRange_name(range_name);
			range.setRange_value(range_value);

			return appService.saveRange(range);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public EntityProduct saveProduct(double grade , String name ,double price, int selected, int issue_id) {
		try {
			EntityProduct product = new EntityProduct();
			product.setGrade(grade);
			product.setName(name);
			product.setPrice(price);
			product.setSelected(selected);
			product.setIssue_id(issue_id);
			return  appService.saveProduct(product);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateProduct( int productId, double grade , String name ,double price, int selected) {
		try {

			  appService.updateProduct(productId, grade, name, price,selected);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public EntityProductDetails saveProductDetails(int cid, int rid, int pid, double weight) {
		try {
			EntityProductDetails details = new EntityProductDetails();

			details.setCriteria_id(cid);
			details.setProduct_id(pid);
			details.setRange_id(rid);
			details.setWeight(weight);

			return  appService.saveProductDetails(details);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void saveDecisionAnalysis(List<Product> products, List<Criteria> crts, List<Range> ranges) {
		appService.saveDecisionAnalysis(products, crts, ranges);
	}


	public void saveAllIssue () {

	}



}
