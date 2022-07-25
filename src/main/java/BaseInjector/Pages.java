package BaseInjector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import vtigerCucumber.pom.CreateNewOrganizationPaged;
import vtigerCucumber.pom.HomePaged;
import vtigerCucumber.pom.LoginPaged;
import vtigerCucumber.pom.OrganizationInfoPaged;
import vtigerCucumber.pom.OrganizationsPaged;

public class Pages {

	public static LoginPaged loginpage;
	public static HomePaged homepaged;
	public static OrganizationsPaged organizationspaged;
	public static CreateNewOrganizationPaged createneworganizationpaged;
	public static OrganizationInfoPaged organizationinfopaged;
	
	
	public static void loadPages(WebDriver driver) {
		loginpage=PageFactory.initElements(driver,LoginPaged.class );
		homepaged=PageFactory.initElements(driver,HomePaged.class );
		organizationspaged=PageFactory.initElements(driver,OrganizationsPaged.class );
		createneworganizationpaged=PageFactory.initElements(driver,CreateNewOrganizationPaged.class );
		organizationinfopaged=PageFactory.initElements(driver,OrganizationInfoPaged.class );
	}
	
}
