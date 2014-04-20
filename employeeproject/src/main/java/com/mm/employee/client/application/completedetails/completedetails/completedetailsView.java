package com.mm.employee.client.application.completedetails.completedetails;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.mm.employee.shared.Employee;

public class completedetailsView extends ViewImpl implements
		completedetailsPresenter.MyView {
	interface Binder extends UiBinder<Widget, completedetailsView> {
	}

	@UiField
	SimplePanel main;
	@UiField
	Label firstLabel;
	@UiField
    FlexTable EmpTable;
	@UiField 
	Hyperlink clickme,clickme1;
	@Inject
	completedetailsView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == completedetailsPresenter.SLOT_completedetails) {
			main.setWidget(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

	public void setColumnHeading()
	{
		EmpTable.setWidget(0, 0, new Label("Emp ID"));
		EmpTable.setWidget(0, 1, new Label("AGE"));
		EmpTable.setWidget(0, 2, new Label("Name"));
		EmpTable.setWidget(0, 3, new Label("Address"));
		EmpTable.setWidget(0, 4, new Label("delete Button"));
	}


	@Override
	public void viewEmployeeDetails(Employee employee) 
	{
		// clearing the employeetable initially
		// Panel for each employee details
        int rowCount =EmpTable.getRowCount();
		
		if(rowCount==0)
			setColumnHeading();
		rowCount++;
		Label idlabel = new Label(employee.getEmp_id() + "");
		Label agelabel = new Label(employee.getAge() + "");
		Label namelabel = new Label(employee.getName());
		Label addresslabel = new Label(employee.getAddress());
		Button deletebutton = new Button("Delete");  
		idlabel.setWidth("50px");
		agelabel.setWidth("50px");
		namelabel.setWidth("50px");
		addresslabel.setWidth("50px");
		deletebutton.setWidth("50px");
		// adding the final row to the Main Panel		
		EmpTable.setWidget(rowCount, 0, idlabel);
		EmpTable.setWidget(rowCount, 1, agelabel );
		EmpTable.setWidget(rowCount, 2, namelabel);
		EmpTable.setWidget(rowCount, 3, addresslabel);
		final Integer index=rowCount;
		deletebutton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				EmpTable.removeRow(index);
			}
			
		}) ;
	}
		


	@Override
	public void clearTable() {
		EmpTable.clear();

	}

	@Override
	public Label getLabel() {
		// TODO Auto-generated method stub
		return firstLabel;
	}


	

}
