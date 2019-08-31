package com.audiotorium2.service;

import java.util.List;


import com.audiotorium2.entity.Item;


public interface IAppService {


	public List<Item> createItems(int size);
	 public List<String> getColors();
	 public List<String> getBrands();
	
	 public List<Item> getItemsByUserName(String userName);
}
