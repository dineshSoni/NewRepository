package com.mm.employee.client.application.show.show;

import java.util.Iterator;
import java.util.List;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.mm.employee.client.application.LeaveType.leavetype.LeaveTypePresenter;
import com.mm.employee.client.place.NameTokens;
import com.mm.employee.shared.Employee;
import com.mm.employee.shared.EmployeeDB;

public class ShowPresenter extends
		Presenter<ShowPresenter.MyView, ShowPresenter.MyProxy> implements
		DisplayUIHandler {
	interface MyView extends View, HasUiHandlers<DisplayUIHandler> {
		public void addEmployee(Employee employee);

		public void clearTable();

		// public Button getLeaveTypeButton();
		public FlexTable getFlexTable();

	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Show = new Type<RevealContentHandler<?>>();
	// create the object of SLOT_Leavetype in Parent Presenter
	public static final Object SLOT_Leavetype = new Object();

	@NameToken(NameTokens.show)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<ShowPresenter> {
	}

	@Inject
	public ShowPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

	}

	@Inject
	EmployeeDB employeedb;
	@Inject
	PlaceManager placemanager;
	@Inject
	LeaveTypePresenter leaveTypePresenter;

	@Override
	protected void onBind() {
		super.onBind();
		getView().setUiHandlers(this);

	};

	// navigate to complete details presenter
	public void viewEmployeeDetails(Integer empId) {
		PlaceRequest request = new PlaceRequest(NameTokens.completedetails)
				.with("employee_ID", empId.toString());
		// PlaceRequest placeRequest = new
		// PlaceRequest.Builder().nameToken(NameTokens.test).with("employee_ID",empId.toString()).build();
		placemanager.revealPlace(request);
	}

	@Override
	protected void onReset() {

		super.onReset();
		// get the data from the list

		// set the data to the view
		// Making sure to start with a clean Slate/Clearing the previous result
		getView().clearTable();
		List<Employee> employee = employeedb.getAllEmployees();
		Iterator<Employee> it = employee.iterator();
		while (it.hasNext()) {
			final Employee employeelist = it.next();

			getView().addEmployee(employeelist);
		}

	}

	@Override
	public void getEmployeeId(Integer empId) {
		// TODO Auto-generated method stub
		PlaceRequest request = new PlaceRequest(NameTokens.edit).with(
				"employee_ID", empId.toString());
		placemanager.revealPlace(request);
	}

	// call the setInslot of the view
	@Override
	public void editLeaveTypeDetails(Integer empId,String emp_name) {
		leaveTypePresenter.setEmpName(emp_name);
		leaveTypePresenter.setEmpid(empId);
		setInSlot(SLOT_Leavetype, leaveTypePresenter);
		System.out.println("\n entered into the leavetype details \n ");

	}

}
