package com.mm.employee.shared;

/*import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
*/

public class Employee {
	
	
	// Instance var of emp classses
	 int emp_id;
	 int age;
	 String name;
	 String address;

	public Employee(int emp_id, int age, String name, String address) {
		this.emp_id = emp_id;
		this.age= age;
		this.name = name;
		this.address = address;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	/*List<LeaveType> allowedleave = new ArrayList<LeaveType>();

	// function to check the allowed leave types
	public boolean assignAllowedLeaveType(LeaveType leavecode) {

		if (!allowedleave.contains(leavecode)) {

			allowedleave.add(leavecode);
			return true;
		}

		else
			return false;

	}

	
	// function to check the allowed LeaveTypes
	public boolean isEligibleToTake( LeaveType leave_code) {
		
		//Check the Leavetype list and match with the leave_code 
		  Iterator<LeaveType> it = allowedleave.iterator();
		    while(it.hasNext()){
		    //Get the next element of the list with the leave_code
		    	if((it.next()).equals(leave_code)){
		    	return true;
		    }
			
		    
		}
		return false;
		
	}


	//returning the emp name
	public String getName() {
		return name;
	}

	//returning the emp id
	public int  getID() {
		return emp_id;
	}
	
	
	public int getManager_id(){
		return manager_id;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee)
		{
			if((emp_id == ((Employee)obj).emp_id))
				return true;
			else 
				return false;
		}
		else
			return super.equals(obj);
	}

	
	
	
	*/
}
