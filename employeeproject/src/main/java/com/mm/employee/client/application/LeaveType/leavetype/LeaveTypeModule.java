package com.mm.employee.client.application.LeaveType.leavetype;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class LeaveTypeModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(LeaveTypePresenter.class,
				LeaveTypePresenter.MyView.class, LeaveTypeView.class,
				LeaveTypePresenter.MyProxy.class);
	}
}
