package com.mm.employee.client.application.LeaveType.leavetype;

import java.util.List;

import com.gwtplatform.mvp.client.UiHandlers;

public interface LeaveTypeUiHandlers extends UiHandlers {
	
public void storeAssignLeave(Integer emp_id,List<String> assignlist);

	
	
}
