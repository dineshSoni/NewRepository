package com.mm.employee.client.application.show.show;

import com.gwtplatform.mvp.client.UiHandlers;

public interface DisplayUIHandler extends UiHandlers {
	
	public void viewEmployeeDetails(Integer empId);
	public void getEmployeeId(Integer empId);
	public void editLeaveTypeDetails(Integer empId,String empname);

}
