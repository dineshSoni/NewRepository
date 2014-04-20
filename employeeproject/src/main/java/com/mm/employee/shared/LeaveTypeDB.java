package com.mm.employee.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LeaveTypeDB {

	
	
	public Map<Integer,List<String>> assignLeaveDB=new HashMap<Integer,List<String>>();
	
	public void addLeaveTypes(Integer emp_id,List<String>assignleave)
	{
		assignLeaveDB.put(emp_id, assignleave);
	}
	
	public int countAssignList()
	{
	 return	assignLeaveDB.size();
	}
	public List<String> searchLeavesByEmpId(Integer emp_id) 
	{
		for (Map.Entry<Integer,List<String>> entry : assignLeaveDB.entrySet()) {
			
			if(assignLeaveDB.containsKey(emp_id))
			{
				List<String> assignedLeaves = entry.getValue();
				return assignedLeaves;
				
			}

			System.out.println("\n Employee id is  : " + entry.getKey()
					+ "\t LeaveTypes Asssigned to the emp are :   " + entry.getValue());
		}
		return null;
		
		
	}

}
