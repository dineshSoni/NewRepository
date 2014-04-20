package com.mm.employee.client.application.edit.edit;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.mm.employee.client.place.NameTokens;
import com.mm.employee.shared.Employee;
import com.mm.employee.shared.EmployeeDB;

public class EditPresenter extends
		Presenter<EditPresenter.MyView, EditPresenter.MyProxy> implements
		EditUiHandlers {
	interface MyView extends View, HasUiHandlers<EditUiHandlers> {
	
    	Label getId();
    	TextBox getAge();
    	TextBox getName();
    	TextBox getAddress();
		public void editviewEmployeeDetails(Employee employee);
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Edit = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.edit)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<EditPresenter> {
	}

	@Inject
	public EditPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

		getView().setUiHandlers(this);
	}
	@Inject
	EmployeeDB employeedb;
	//getting the id from show presenter to edit presenter using get parameter method
	public void prepareFromRequest(PlaceRequest request) {
		// TODO Auto-generated method stub
		super.prepareFromRequest(request);
		String id = request.getParameter("employee_ID","Not found");
		
		Integer emp_id=Integer.parseInt(id);
		//using id search the employee details get the all values
		 Employee employee= employeedb.searchEmpDataById(emp_id);
		 //call this method and pass employee reference into the view
		 getView().editviewEmployeeDetails(employee);
		 
		   }
	//get the id and update the values
	@Override
	public void updateEmpValues(int id1) {
	   employeedb.deleteEmpByID(id1);
	   //get the value form the text box
	   Employee empObj=new Employee(Integer.parseInt(getView().getId().getText()),
			   Integer.parseInt(getView().getAge().getText()),
			   getView().getName().getText(), getView().getAddress().getText());
			//call to the addEmployee Method and pass the object of employee 
			employeedb.addEmployee(empObj);
			Window.alert("Successfuly Updated");
		
	}

}



