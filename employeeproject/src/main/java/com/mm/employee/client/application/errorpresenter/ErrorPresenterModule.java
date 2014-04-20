package com.mm.employee.client.application.errorpresenter;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ErrorPresenterModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(ErrorPresenterPresenter.class,
				ErrorPresenterPresenter.MyView.class, ErrorPresenterView.class,
				ErrorPresenterPresenter.MyProxy.class);
	}
}
