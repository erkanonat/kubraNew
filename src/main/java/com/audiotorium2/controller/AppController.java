package com.audiotorium2.controller;

import java.util.ArrayList;
import java.util.List;

import com.audiotorium2.core.EntityCriteria;
import com.audiotorium2.core.EntityIssue;
import com.audiotorium2.core.EntityRange;
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

	public EntityRange saveRange(String name ) {
		try {


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return   null;
	}

	public EntityRange saveProduct(String name ) {
		try {


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return   null;
	}

	public EntityRange saveProductDetails(String name ) {
		try {


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return   null;
	}

	public void saveDecisionAnalysis(List<Product> products, List<Criteria> crts, List<Range> ranges) {
		appService.saveDecisionAnalysis(products, crts, ranges);
	}

}
