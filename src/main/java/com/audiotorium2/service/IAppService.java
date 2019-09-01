package com.audiotorium2.service;

import java.util.List;

import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Item;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;


public interface IAppService {


	public void saveDecisionAnalysis(List<Product> products, List<Criteria> crts, List<Range> ranges);
	
	public List<Item> createItems(int size);
	 public List<String> getColors();
	 public List<String> getBrands();
	
	 public List<Item> getItemsByUserName(String userName);
}
