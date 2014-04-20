package com.mm.employee.client.application.show.show;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ShowModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(ShowPresenter.class, ShowPresenter.MyView.class,
				ShowView.class, ShowPresenter.MyProxy.class);
	}
}
