package com.mm.employee.client.application.errorpresenter;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ErrorPresenterView extends ViewImpl implements
		ErrorPresenterPresenter.MyView {
	interface Binder extends UiBinder<Widget, ErrorPresenterView> {
	}

	@UiField
	SimplePanel main;

	@Inject
	ErrorPresenterView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == ErrorPresenterPresenter.SLOT_ErrorPresenter) {
			main.setWidget(content);
		} else {
			super.setInSlot(slot, content);
		}
	}
}
