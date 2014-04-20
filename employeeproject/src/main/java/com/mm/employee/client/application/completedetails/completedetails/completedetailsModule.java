package com.mm.employee.client.application.completedetails.completedetails;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class completedetailsModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(completedetailsPresenter.class,
				completedetailsPresenter.MyView.class,
				completedetailsView.class,
				completedetailsPresenter.MyProxy.class);
	}
}
