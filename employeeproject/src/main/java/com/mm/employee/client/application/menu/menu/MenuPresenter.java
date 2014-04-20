package com.mm.employee.client.application.menu.menu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.Presenter.RevealType;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.mm.employee.client.application.ApplicationPresenter;
import com.mm.employee.client.place.NameTokens;

public class MenuPresenter extends
		Presenter<MenuPresenter.MyView, MenuPresenter.MyProxy> {
	interface MyView extends View {
		Button getAddButton();

		Button getShowButton();
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Menu = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.menu)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<MenuPresenter> {
	}

	@Inject
	public MenuPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

	}

	@Inject
	PlaceManager placemanager;

	@Override
	protected void onBind() {
		super.onBind();
		getView().getAddButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				PlaceRequest request = new PlaceRequest(NameTokens.home);
				placemanager.revealPlace(request);
			}

		});
		getView().getShowButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				PlaceRequest request = new PlaceRequest(NameTokens.show);
				placemanager.revealPlace(request);
			}

		});
	}
@Override
protected void onReset() {
	// TODO Auto-generated method stub
	super.onReset();
}
}
