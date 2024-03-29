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

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomePageView extends ViewImpl implements HomePagePresenter.MyView {
    public interface Binder extends UiBinder<Widget, HomePageView> {
    }
@UiField
 TextBox id; 
@UiField 
 TextBox age;
 @UiField
 TextBox name;
 @UiField
 TextBox address;
 @UiField
 Button button;
    @Inject
    public HomePageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
	@Override
	public Button getButton() {
		// TODO Auto-generated method stub
		return button;
	}
	@Override
	public TextBox getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public TextBox getAge() {
		// TODO Auto-generated method stub
		return age;
	}
	@Override
	public TextBox getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public TextBox getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
}
