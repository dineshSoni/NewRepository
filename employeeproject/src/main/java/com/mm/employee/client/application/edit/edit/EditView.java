package com.mm.employee.client.application.edit.edit;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.mm.employee.shared.Employee;
import com.mm.employee.shared.EmployeeDB;

public class EditView extends ViewWithUiHandlers<EditUiHandlers> implements
		EditPresenter.MyView {
	interface Binder extends UiBinder<Widget, EditView> {
	}

	@UiField
	SimplePanel main;
	@UiField
	 Label id; 
	@UiField 
	 TextBox age;
	 @UiField
	 TextBox name;
	 @UiField
	 TextBox address;
	 @UiField
	 Button save;
	@Inject
	EditView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}
@Inject
EmployeeDB employeedb;
	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == EditPresenter.SLOT_Edit) {
			main.setWidget(content);
		} else {
			super.setInSlot(slot, content);
		}
	}
	
	@Override
	public void editviewEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
	    // through the employee object get the value and set into label and textbox
	     id.setText(employee.getEmp_id() + "");
		id.setWidth("100px");
	    age.setText(employee.getAge()+"");
	    age.setWidth("100px");
	    name.setText(employee.getName());
	    name.setWidth("100px");
	    address.setText(employee.getAddress());
	    address.setWidth("100px");
	 // final int id1=Integer.parseInt(id.getText());
			
			save.addClickHandler(new ClickHandler()
			 {
				
				@Override
				public void onClick(ClickEvent event) {
					//pass the existing id and update the details of particular employee
					getUiHandlers().updateEmpValues(Integer.parseInt(id.getText()));
				
				}
			});
		
		
		
		}

	@Override
	public Label getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public TextBox getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	@Override
	public TextBox getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public TextBox getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
			


		

		
		
	}

