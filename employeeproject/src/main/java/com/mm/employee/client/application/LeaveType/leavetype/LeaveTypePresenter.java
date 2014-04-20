package com.mm.employee.client.application.LeaveType.leavetype;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.mm.employee.client.application.show.show.ShowPresenter;
import com.mm.employee.client.place.NameTokens;
import com.mm.employee.shared.LeaveTypeDB;

public class LeaveTypePresenter extends
		Presenter<LeaveTypePresenter.MyView, LeaveTypePresenter.MyProxy>
		implements LeaveTypeUiHandlers {
	interface MyView extends View, HasUiHandlers<LeaveTypeUiHandlers> {
		public void setemployeeId(int emp_id);
		public void setEmployeeName(String emp_name);
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_LeaveType = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.leaveType)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<LeaveTypePresenter> {
		
	}

	@Inject
	public LeaveTypePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ShowPresenter.SLOT_Show);

		getView().setUiHandlers(this);
	}
 
	String emp_name;
   public void setEmpName(String emp_name) {
		// TODO Auto-generated method stub
		this.emp_name=emp_name;
		
		getView().setEmployeeName(emp_name);
	}
   int emp_id;
   public void setEmpid(int emp_id) {
		this.emp_id= emp_id;
		getView().setemployeeId(emp_id);
		
	}
   @Override
	protected void onReset() {

		super.onReset();

	}
	
	@Inject 
	LeaveTypeDB leavetypedb;
	@Override
	public void storeAssignLeave(Integer emp_id, List<String> assignlist) {
		// Store the Details of assign leave into LeaveTypeDb
     	leavetypedb.addLeaveTypes(emp_id, assignlist);
		Window.alert("Success full assign leave"+leavetypedb.countAssignList());
		
	}


	
	
	

}
