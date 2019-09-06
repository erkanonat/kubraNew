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

	public void saveDecisionAnalysis(List<Product> products, List<Criteria> crts, List<Range> ranges) {
			
//		for(int i=0;i<products.size();i++) {
//			dao.saveProduct(products.get(i));
//		}
//		for(int j=0;j<crts.size();j++) {
//			dao.saveCriteria(crts.get(j));
//		}
//		for(int k=0;k<ranges.size();k++) {
//			dao.saveRange(ranges.get(k));
//		}
	}


}
