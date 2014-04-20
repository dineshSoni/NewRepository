package com.mm.employee.client.application.completedetails.completedetails;

import java.util.Iterator;
import java.util.List;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.mm.employee.client.application.ApplicationPresenter;
import com.mm.employee.client.place.NameTokens;
import com.mm.employee.shared.Employee;
import com.mm.employee.shared.EmployeeDB;

public class completedetailsPresenter extends
		Presenter<completedetailsPresenter.MyView, completedetailsPresenter.MyProxy> {
	interface MyView extends View {
		public void viewEmployeeDetails(Employee employee) ;
		 public void clearTable();
		 Label getLabel();
		
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_completedetails = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.completedetails)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<completedetailsPresenter> {
	}

	@Inject
	public completedetailsPresenter(EventBus eventBus, MyView view,
			MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

	}
@Inject
EmployeeDB employeedb;
	
@Override
public void prepareFromRequest(PlaceRequest request) {
	// TODO Auto-generated method stub
	super.prepareFromRequest(request);
	String id = request.getParameter("employee_ID","Not found");
	
	Integer emp_id=Integer.parseInt(id);
	 getView().clearTable();
	 Employee employee= employeedb.searchEmpDataById(emp_id);
		
		getView().clearTable();
        getView().viewEmployeeDetails(employee);
	   }
			  
 	
	
}

/*@Override
protected void onReset() {
	
	super.onReset();
    List<Employee> employee= employeedb.getAllEmployees();
		Iterator<Employee> it = employee.iterator();
		
		while (it.hasNext()) 
		{

			  final Employee employeelist = it.next();
			   getView().addEmployee(employeelist);
    	}

}
	*/



