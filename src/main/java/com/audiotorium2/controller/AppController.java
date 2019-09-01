package com.audiotorium2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Item;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;
import com.audiotorium2.service.IAppService;

@Controller
public class AppController {

	
	@Autowired
	IAppService appService;

	public void saveDecisionAnalysis(List<Product> products, List<Criteria> crts, List<Range> ranges) {
		appService.saveDecisionAnalysis(products, crts, ranges);
	}
	
	public List<Item> getMyItems(){
		
		
		return appService.getItemsByUserName("");
	}
	
	
	public List<Item> listItems(){
		
		List<Item> result = new ArrayList<Item>();
		
		for (int i = 0; i < 10; i++) {
			
			
		}
		
		return result;
	}
	
	
}
