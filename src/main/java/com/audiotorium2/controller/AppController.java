package com.audiotorium2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audiotorium2.entity.Item;
import com.audiotorium2.service.IAppService;

@Controller
public class AppController {

	
	@Autowired
	IAppService appService;

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
