package com.mm.employee.client.application.testpresenter;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class TestPresenterView extends ViewImpl implements
		TestPresenterPresenter.MyView {
	interface Binder extends UiBinder<Widget, TestPresenterView> {
	}

	@UiField
	SimplePanel main;

	@Inject
	TestPresenterView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == TestPresenterPresenter.SLOT_TestPresenter) {
			main.setWidget(content);
		} else {
			super.setInSlot(slot, content);
		}
	}
}
