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

package com.mm.employee.client.application;

import com.mm.employee.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.mm.employee.client.application.menu.menu.MenuModule;
import com.mm.employee.client.application.show.show.ShowModule;
import com.mm.employee.client.application.completedetails.completedetails.completedetailsModule;
import com.mm.employee.client.application.errorpresenter.ErrorPresenterModule;
import com.mm.employee.client.application.testpresenter.TestPresenterModule;
import com.mm.employee.client.application.edit.edit.EditModule;
import com.mm.employee.client.application.LeaveType.leavetype.LeaveTypeModule;



public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
		
	
		
		install(new LeaveTypeModule());
		install(new EditModule());
		install(new TestPresenterModule());
		install(new ErrorPresenterModule());
		install(new completedetailsModule());
		install(new ShowModule());
		install(new MenuModule());
		install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
