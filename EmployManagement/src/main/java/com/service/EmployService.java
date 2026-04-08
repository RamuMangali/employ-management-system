package com.service;

import java.util.List;

import com.dao.EmployDao;
import com.dto.EmployDetails;
import com.exception.UserException;

public class EmployService {
	EmployDao dao= new EmployDao();
	public void employRegistration(EmployDetails ed1)
	{ 
		//System.out.println(ed1+"ed1");
		EmployDetails ed2 = new EmployDetails();
		long mobile = ed1.getMobile();
		
			ed2.setMobile(mobile);
		
		
		
		String password=ed1.getPassword();
	
			ed2.setPassword(password);
		
		ed2.setId(ed1.getId());
		ed2.setName(ed1.getName());
		ed2.setEmail(ed1.getEmail());
		ed2.setGender(ed1.getGender());
		ed2.setAddress(ed1.getAddress());
		dao.inserEmployDetails(ed2);
//		System.out.println("service"+ed2);
	}
	
	public List<EmployDetails> allDetails() {
		// TODO Auto-generated method stub
		return dao.getAllDetails();
	}

	public void deleteData(int id) {
		// TODO Auto-generated method stub
		dao.deleteDetails(id);
		
	}

	public EmployDetails update(int id) {
		// TODO Auto-generated method stub
		return dao.updateDetails(id);
		
		
	}

	public void updateDetails(EmployDetails ed) {
		// TODO Auto-generated method stub
		dao.updatedet(ed);
		
	}

	public List<EmployDetails> filterDetails(String value) {
		// TODO Auto-generated method stub
		return dao.filterDet(value);
	}

	




}
