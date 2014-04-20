/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.mm.employee.client.application.home;

import com.mm.employee.client.application.ApplicationPresenter;
import com.mm.employee.client.place.NameTokens;
import com.mm.employee.shared.Employee;
import com.mm.employee.shared.EmployeeDB;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.Presenter.RevealType;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
    public interface MyView extends View {
    	Button getButton();
    	TextBox getId();
    	TextBox getAge();
    	TextBox getName();
    	TextBox getAddress();
    	
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    public interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }
    //inject the object of EmployeeDB to accessing the method
@Inject
EmployeeDB employeedb;
    @Inject
    public HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
    }
    @Override
	
    protected void onBind() {
    	super.onBind();
    	getView().getButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// create the obj of Employee class to pass the value to the constructor
				Employee empObj=new Employee(Integer.parseInt(getView().getId().getText()),Integer.parseInt(getView().getAge().getText()),getView().getName().getText(),getView().getAddress().getText());
				//call to the addEmployee Method and pass the object of employee 
				employeedb.addEmployee(empObj);
			Window.alert("Successfuly added to employee Details:" + employeedb.getEmployeeCount());
			}
		});
    }
}

