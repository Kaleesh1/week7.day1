package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends ProjectSpecificMethods {

	@Given ("Click on CRMSFA")
	public void clickOnCRMSFA() {
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	}
	@And ("Click on CreateLead shortcut")
	public void createLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		
	}
	@When ("Enter CompanyName as (.*)$")
	public void enterCompanyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}
	@And ("Enter FirstName as (.*)$")
	public void enterFirstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		
	}
	@And ("Enter LastName as (.*)$")
	public void enterLastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		
	}
	@And ("Click on createLead button")
	public void clickOnCreateLeadButton() {
		WebElement createLeadButton = driver.findElement(By.name("submitButton"));
		builder.scrollToElement(createLeadButton);
		createLeadButton.click();
		
	}
	@Then ("verify the ViewLeadsPage")
	public void verifyLeadCreated() {
		
		String titleAfterLeadCreation = driver.getTitle();
		
		if (titleAfterLeadCreation.contains("View Lead")) {
			System.out.println("Verified that lead created sucessfully");
		}else {
			System.out.println("Issue with Lead creation");
		}
	}
}
