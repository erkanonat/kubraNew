package com.audiotorium2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.audiotorium2.entity.Item;

@Service
public class AppServiceImp implements IAppService {

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

}
