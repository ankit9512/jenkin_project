package com.demo3.service;

import com.demo3.dao.DemoDao;
import com.demo3.dao.DemoDaoInterface;
import com.demo3.entity.DemoEntity;

public class DemoService implements DemoServiceInterface {
   
	private DemoService(){}
	public static DemoServiceInterface createServiceObject() {
		return new DemoService();
	}

	@Override
	public int createProfile(DemoEntity de) {

		DemoDaoInterface ddi=DemoDao.createDaoObject();
		
		return ddi.createDaoprofile(de);
	}

}
