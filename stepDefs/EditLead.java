package stepDefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLead extends ProjectSpecificMethods{
	
	String compNameBeforeUpd = "";
	String firstNameBeforeUpd = "";
	String lastNameBeforeUpd = "";
	String compNameAfterUpd = "";
	String firstNameAfterUpd = "";
	String lastNameAfterUpd = "";
	
	@Given ("Click on CRMSFA edt")
	public void clickOnCrmsfaEdt() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And ("Click on leads tab")
	public void clickOnLeadsTab() {
		driver.findElement(By.linkText("Leads")).click();
	}
	@And ("Click on findLeads shortcut")
	public void clickOnFindLeadsShortcut(){
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@And ("Search leadID as (.*)$")
	public void searchLead(String leadID) {
		driver.findElement(By.name("id")).sendKeys(leadID);
	}
	@And ("Click on findLeads button")
	public void findLead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@And ("Click on resultingLead")
	public void clickOnResultinglead() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		String iniValue = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String[] split = iniValue.split(" ");
		compNameBeforeUpd += split[0];
		firstNameBeforeUpd = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		lastNameBeforeUpd = driver.findElement(By.id("viewLead_lastName_sp")).getText();
		System.out.println(compNameBeforeUpd);
		System.out.println(firstNameBeforeUpd);
		System.out.println(lastNameBeforeUpd);
	}
	@When ("Click on editLead")
	public void clickOnEditLeadButton() {
		driver.findElement(By.linkText("Edit")).click();
	}
	@And ("Update CompanyName as (.*)$")
	public void updateCompName(String companyName) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
	}
	@And ("Update FirstName as (.*)$")
	public void updateFirstName (String firstName)  {
		driver.findElement(By.id("updateLeadForm_firstName")).clear();
		driver.findElement(By.id("updateLeadForm_firstName")).sendKeys(firstName);
	}
	@And ("Update LastName as (.*)$")
	public void updateLastName (String lastName) {
		driver.findElement(By.id("updateLeadForm_lastName")).clear();
		driver.findElement(By.id("updateLeadForm_lastName")).sendKeys(lastName);
	}
	@And ("Click on update button")
	public void clickOnUpdateButton() {
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
	}
	@Then ("verify the ViewLeadsPageEdt")
	public void verifyUpdate() {
		String aftUpdValue = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String[] split1 = aftUpdValue.split(" ");
		compNameAfterUpd += split1[0];
		firstNameAfterUpd = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		lastNameAfterUpd = driver.findElement(By.id("viewLead_lastName_sp")).getText();
		System.out.println(compNameAfterUpd);
		System.out.println(firstNameAfterUpd);
		System.out.println(lastNameAfterUpd);
		
		if (compNameBeforeUpd!=compNameAfterUpd && firstNameBeforeUpd!=firstNameAfterUpd && lastNameBeforeUpd!=lastNameAfterUpd) {
			System.out.println("Edit successfull!!!");
		}else {
			System.out.println("Issue with Edit!!!");
		}
		
	}

}
