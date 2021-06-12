package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.I.Is;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.*;

import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

public class usedCarWebTestSteps {

	WebDriver driver;
	boolean carFound = false;

	@Before("@WebTestScenario1")
	public void initialiseWebdriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@After("@WebTestScenario1")
	public void disposeWebdriver() {
		driver.close();
		driver.quit();

	}

	@Given("I search for used cars on Trademe")
	public void i_search_for_used_cars_on_trademe() {

		driver.get("https://www.tmsandbox.co.nz/");
		driver.findElement(By.cssSelector(".nav.verticals-nav.verticals-nav-switcher #SearchTabs1_MotorsAnchor"))
				.click();
//	  driver.findElement(By.cssSelector("#Control_Table a[href=\"/motors/used-cars\"]")).click();
		driver.findElement(By.xpath("//*[text()='Cars for sale']")).click();

	}

	@When("I find a used car listed")
	public void i_find_a_used_car_listed() {

		List<WebElement> rows = driver.findElements(By.cssSelector("table #makes tr"));
		int countOfRows = driver.findElements(By.cssSelector("table #makes tr")).size();

		boolean flag = true;

		for (WebElement row : rows) {
//		System.out.println(row.getText());
			List<WebElement> carModels = row.findElements(By.cssSelector("td"));

			for (WebElement carModel : carModels) {
				String text = carModel.findElement(By.cssSelector("span")).getText();
//			System.out.println(text);

				String numberOfCars = (text.split("\\(")[1]).split("\\)")[0];
				if ((Integer.parseInt(numberOfCars) > 0)) {
//				System.out.println(Integer.parseInt(numberOfCars));
					System.out.println("The total number of " + carModel.getText().split("\\(")[0] + " cars found is :"
							+ Integer.parseInt(numberOfCars));
					System.out.println("The details of this car are as below");
					carModel.findElement(By.cssSelector("a")).click();
					flag = false;
					carFound = true;
					driver.findElement(By.cssSelector(".tmm-search-card-list-view__card")).click();
					break;

				} else
					break;

			}
			if (flag == false)
				break;
		}

//	if (carFound) {
//		driver.findElement(By.cssSelector(".tmm-search-card-list-view__card")).click();
//
//	}

	}

	@Then("I verify that details for Number plate, Kilometres, Body and Seats is shown")
	public void i_verify_that_details_for_number_plate_kilometres_body_and_seats_is_shown() {

		if (carFound) {

			HashMap<String, String> data = new HashMap<String, String>();

			List<WebElement> KeyDetails = driver
					.findElements(By.cssSelector("#AttributesDisplay_attributesSection li"));
			for (WebElement keyDetail : KeyDetails) {
				data.put(keyDetail.findElement(By.cssSelector("label")).getText(),
						keyDetail.findElement(By.cssSelector("span")).getText());
			}

			assertNotEquals(data.get("Number plate"), null);

			System.out.println("Number plate :" + data.get("Number plate"));
			System.out.println("Kilometres :" + data.get("Kilometres"));
			System.out.println("Body :" + data.get("Body"));
			System.out.println("Seats :" + data.get("Seats"));
		} else {
			System.out.println("No cars found");
		}

	}

}
