package StepDefinationsAndHooksClasses;

import org.testng.Assert;

import BaseInjector.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vtigerCucumber.generics.FileUtility;
import vtigerCucumber.pom.LoginPaged;

public class VtigerOrgSteps {

	@Given("In login page enter username and password and then click on login button")
	public void in_login_page_enter_username_and_password_and_then_click_on_login_button() throws Throwable {
		String username = FileUtility.readDataFromPropertyFile("username");
		String password = FileUtility.readDataFromPropertyFile("password");
		Pages.loginpage.loginToApp(username, password);
	}
	@When("Homepage is displayed click on org link")
	public void homepage_is_displayed_click_on_org_link() {
	   Pages.homepaged.clickOnOrgLnk();
	}
	@When("In organizations page click on create new org image")
	public void in_organizations_page_click_on_create_new_org_image() {
	   Pages.organizationspaged.clickOnCreateOrgImg();
	}
	@When("In create new org page enter madatory fields and click on save button")
	public void in_create_new_org_page_enter_madatory_fields_and_click_on_save_button() {
		
	   Pages.createneworganizationpaged.createNewOrg("Amazon");
	}
	@Then("Verify org is ctreated or not")
	public void verify_org_is_ctreated_or_not() {
	    String actualOrgName = Pages.organizationinfopaged.OrgNameInfo();
	    Assert.assertTrue(actualOrgName.contains("Amazon"));
	}

}
