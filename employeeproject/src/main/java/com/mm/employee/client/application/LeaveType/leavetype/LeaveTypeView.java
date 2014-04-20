package com.mm.employee.client.application.LeaveType.leavetype;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class LeaveTypeView extends ViewWithUiHandlers<LeaveTypeUiHandlers>
		implements LeaveTypePresenter.MyView {
	interface Binder extends UiBinder<Widget, LeaveTypeView> {
	}

	@UiField
	HTMLPanel contentPanel;
	@UiField
	Label employeename, employeeid;
	@UiField
	Button addButton;
	@UiField
	Button removeButton;
	@UiField
	Button saveButton;
	@UiField
	ListBox availableLeaveTypes, assignedLeaveTypes;

	@Inject
	LeaveTypeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));

		addButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				// get SelectedIndex from the avilableLeaveTypes listBox
				Integer selectedIndex = availableLeaveTypes.getSelectedIndex();
				// store the selectedIndex into the item variable
				String item = availableLeaveTypes.getItemText(selectedIndex);
				// count the assigendIndex into the assignedLeaveTypes listBox
				Integer assignedIndex = assignedLeaveTypes.getItemCount();

				assignedLeaveTypes.addItem(item);

			}

		});
		removeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Integer selectIndex = assignedLeaveTypes.getSelectedIndex();
				// String
				// removeItem=assignedLeaveTypes.getItemText(selectIndex);
				assignedLeaveTypes.removeItem(selectIndex);
			}

		});

		saveButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String leaveType;
				// create List and to store the Assignlist Item
				List<String> assignlist = new ArrayList<String>();
				for (int i = 0; i <= assignedLeaveTypes.getItemCount(); i++) {
					 leaveType = assignedLeaveTypes.getItemText(i);
					assignlist.add(leaveType);
				}
				Integer emp_id = Integer.parseInt(employeeid.getText());

				// call the method store assign leave and pass emp_id and assign list
			
				getUiHandlers().storeAssignLeave(emp_id, assignlist);
			}

		});

	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == LeaveTypePresenter.SLOT_LeaveType) {
			// main.setWidget(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

	@Override
	public void setEmployeeName(String emp_name) {
		// TODO Auto-generated method stub
		employeename.setText(emp_name);
	}

	@Override
	public void setemployeeId(int emp_id) {
		// TODO Auto-generated method stub
		employeeid.setText(emp_id + "");
	}

}
