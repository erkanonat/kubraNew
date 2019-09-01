package com.audiotorium2.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<Item> createItems(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getColors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getBrands() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemsByUserName(String userName) {
		
		List<Item> result = new ArrayList<Item>();
		
		for (int i = 0; i < 10; i++) {
			String str = String.valueOf(i);
			Item item = new Item( str,str+"brand" , (1900+i), str+"color", (1000+i), true);
			result.add(item);
		}
		
		return result;
	}

	public void saveDecisionAnalysis(List<Product> products, List<Criteria> crts, List<Range> ranges) {
			
		for(int i=0;i<products.size();i++) {
			dao.saveProduct(products.get(i));
		}
		for(int j=0;j<crts.size();j++) {
			dao.saveCriteria(crts.get(j));
		}
		for(int k=0;k<ranges.size();k++) {
			dao.saveRange(ranges.get(k));
		}
	}
}
