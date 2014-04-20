package com.mm.employee.client.application.testpresenter;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TestPresenterModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(TestPresenterPresenter.class,
				TestPresenterPresenter.MyView.class, TestPresenterView.class,
				TestPresenterPresenter.MyProxy.class);
	}
}
