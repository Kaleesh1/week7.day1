package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPage extends ProjectSpecificMethods{


	@Given ("Enter the user name {string}")
	public void typeUname(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And ("Enter the password {string}")
	public void typePass(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And ("click on login")
	public void clickOnLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then ("the user home page should be displayed.")
	public void loginPageCheck() {
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);

		// Finally, we need to check if we are correct page !!
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));

		// findElement --> find the first matching element by the given locator in the DOM / web page !
		// if there is no match -> it will throw exception -> NoSuchElement !!

		// Get the attribute and print
		String attribute = logout.getAttribute("value");
		System.out.println(attribute);
		if(attribute.equals("Logout")) {
			System.out.println("Successfully Logged In");
		}

	}
	@But ("error message should be displayed for incorrect creds.")
	public void errorCheck() {
		System.out.println("loginError");
	}

}
