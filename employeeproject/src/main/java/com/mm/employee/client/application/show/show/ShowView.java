package com.mm.employee.client.application.show.show;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.mm.employee.shared.Employee;
import com.mm.employee.shared.EmployeeDB;

public class ShowView extends ViewWithUiHandlers<DisplayUIHandler> implements
		ShowPresenter.MyView {
	interface Binder extends UiBinder<Widget, ShowView> {
	}

	
	
	@UiField
	HTMLPanel leaveTypePanel;

	@UiField
	Hyperlink gotomenu;
	@UiField
	FlexTable EmpTable;

	@Inject
	ShowView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}
//to check the slot 
	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == ShowPresenter.SLOT_Leavetype) {
			leaveTypePanel.clear();
			if (content != null) {
				leaveTypePanel.add(content);
			}
		} else {
			super.setInSlot(slot, content);
		}

	}

	public void setColumnHeading() {
		EmpTable.setWidget(0, 0, new Label("Emp ID"));
		EmpTable.setWidget(0, 1, new Label("Emp name"));
		EmpTable.setWidget(0, 2, new Label("Delete"));
		EmpTable.setWidget(0, 3, new Label("Edit"));
		EmpTable.setWidget(0, 4, new Label("LeaveTypes"));
	}

	@Inject
	EmployeeDB employeedb;

	@Override
	public void addEmployee(final Employee employee) {
		// clearing the employee table initially

		// returns entire row count of table
		int rowCount = EmpTable.getRowCount();

		if (rowCount == 0)
			setColumnHeading();
		rowCount++;

		Label idLabel = new Label(employee.getEmp_id() + "");
		idLabel.setWidth("50px");
		final Integer empId = (employee.getEmp_id());
        final String empname=(employee.getName());
		Anchor name = new Anchor();
		name.setText(employee.getName());
		name.setWidth("50px");
		// EmpTable.setWidget(rowCount, 1, name);
		name.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getUiHandlers().viewEmployeeDetails(empId);

				// call viewEmplopyeedetails function in showPresenter
				// showPresenter.viewEmployeeDetails(empId);

			}
		});

		Button deletebutton = new Button("Delete");
		deletebutton.setWidth("50px");
		Button editbutton = new Button("edit");
		editbutton.setWidth("50px");
		Button leavetypeButton = new Button("LeaveType");
		EmpTable.setWidget(rowCount, 0, idLabel);
		EmpTable.setWidget(rowCount, 1, name);
		EmpTable.setWidget(rowCount, 2, deletebutton);
		EmpTable.setWidget(rowCount, 3, editbutton);
		EmpTable.setWidget(rowCount, 4, leavetypeButton);
		final Integer index = rowCount;
		//add click Handler on Delete Button
		deletebutton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// proddb.deleteProduct(product.getProd_id());
				EmpTable.removeRow(index);
				// empTable.removeRow();
				employeedb.deleteEmpByID(employee.getEmp_id());
				Window.alert("The Emp " + employee.getName()
						+ "is deleted successfully from DB");
			}
		});
		//add click Handler on Edit Button
		editbutton.addClickHandler(new ClickHandler() {
            @Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				getUiHandlers().getEmployeeId(empId);
			}

		});
		
		//add click Handler on leaveType Button
		leavetypeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// calling the editEmpDetils method form view to presenter
			
				getUiHandlers().editLeaveTypeDetails(empId,empname);
				
			}

		});

	}

	@Override
	public void clearTable() {
		EmpTable.clear();
		EmpTable.removeAllRows();
	}

	@Override
	public FlexTable getFlexTable() {
		
		return EmpTable;
	}
}
