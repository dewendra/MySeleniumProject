package com.procam;

import org.testng.annotations.Test;

import com.procam.base.BaseClass;
import com.procam.pageobject.EventDashBoard;
import com.procam.pageobject.EventsList;
import com.procam.pageobject.LoginPage;
import com.procam.pageobject.VendorDashBaoardPage;

public class LoginTest extends BaseClass{
	
	private LoginPage loginPage;
	private VendorDashBaoardPage vendorDashBaoardPage;
	private EventsList eventsList;
	private EventDashBoard eventDashBoard;
	
	@Test
	public void verifyLogin() {
		loginPage=new LoginPage();
		vendorDashBaoardPage=loginPage.loginByEmail();
		eventsList=vendorDashBaoardPage.selectOptions();
		eventDashBoard=eventsList.selectEvent();
		eventDashBoard.selectParticipantOption();
	}

}
