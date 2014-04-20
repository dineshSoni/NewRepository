package com.mm.employee.client.application.menu.menu;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class MenuView extends ViewImpl implements MenuPresenter.MyView {
	interface Binder extends UiBinder<Widget, MenuView> {
	}

	@UiField
	SimplePanel main;
    @UiField 
    Button add;
    @UiField 
    Button show;
	@Inject
	MenuView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == MenuPresenter.SLOT_Menu) {
			main.setWidget(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

	@Override
	public Button getAddButton() {
		// TODO Auto-generated method stub
		return add;
	}

	@Override
	public Button getShowButton() {
		// TODO Auto-generated method stub
		return show;
	}


}
