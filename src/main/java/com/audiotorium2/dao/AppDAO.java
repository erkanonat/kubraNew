package com.audiotorium2.dao;

import javax.sql.DataSource;

import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;

public class AppDAO implements IAppDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public String saveProduct(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveCriteria(Criteria c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveRange(Range r) {
		// TODO Auto-generated method stub
		return null;
	}

}
