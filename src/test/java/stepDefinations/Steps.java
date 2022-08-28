package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainCareerPage;
import pageObjects.PageQaEngineer;

public class Steps {
	public WebDriver driver;

	SoftAssert softasserts = new SoftAssert();

	@Given("Open the application link {string}")
	public void open_the_application_linkt(String string) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MH\\Desktop\\ICONS\\Naumadic\\NAQT\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		MainCareerPage.driver = driver;
		PageQaEngineer.driver = driver;
		driver.manage().window().maximize();
		driver.get(string);
	}

	@Then("Verfiy The header text {string}")
	public void verfiy_the_header_text(String string) {

		String headertxt = MainCareerPage.headertxt().getText(); // Actual Header text

		// Using Soft Assertion
		softasserts.assertEquals(string, headertxt);
	}

	@Then("Select Internship from job type dropdown list")
	public void select_internship_from_job_type_dropdown_list() throws Throwable {

		WebElement dp = driver.findElement(By.xpath("//select[@id='job_type']"));
		Select s = new Select(dp);
		s.selectByVisibleText("Internship");
	}

	@Then("The Message Should Be {string}")
	public void the_message_should_be(String textmsg) throws Throwable {

		String msg = MainCareerPage.msg();
		if (msg.equals(textmsg)) {
			System.out.println("Text is Matched : " + msg);
			Assert.assertTrue(true);
		} else {
			System.out.println("Text is Not Matched : " + msg);
			Assert.assertTrue(false);
		}
	}

	@When("Select  Full time from job type dropdown list")
	public void select_full_time_from_job_type_dropdown_list() throws Throwable {

		Thread.sleep(2000);
		WebElement fdp = driver.findElement(By.xpath("//select[@id='job_type']"));
		Select s = new Select(fdp);
		s.selectByVisibleText("Full time");
	}

	@When("Select QA Engineer From job listing options")
	public void select_qa_engineer_from_job_listing_options() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(2000);
		WebElement clickonQA = MainCareerPage.clickonQA();
		clickonQA.click();
	}

	@Then("Verify url redirects to {string}")
	public void verify_url_redirects_to(String string) throws Throwable {

		Thread.sleep(2000);
		String url = MainCareerPage.getURL();
		if (url.equals(string)) {
			System.out.println(" url is Matched : " + url);
		} else {
			System.out.println("url is Not Matched : " + url);
		}
	}

	@Then("Verify button Apply here now &  perform a click action")
	public void verify_button_apply_here_now_perform_a_click_action() throws Throwable {

		Thread.sleep(2000);
		PageQaEngineer.verifyandClickBtn().click();
	}

	@Then("Verify redirect back to careers page")
	public void verify_redirect_back_to_careers_page() throws Throwable {

		Thread.sleep(2000);
		String url = PageQaEngineer.getURL();
		if (url.equals("https://numadic.com/careers/#careersFormContainer")) {
			System.out.println(" Redirected url is Matched : " + url);
		} else {
			System.out.println("Redirected url is Not Matched : " + url);
		}
	}

	@When("On listing page, hover over QA Engineer")
	public void on_listing_page_hover_over_qa_engineer() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(600,0)", "");
		Thread.sleep(2000);
		MainCareerPage.hoveronQA();
	}

	@Then("Apply button will Be Visible and click Apply button")
	public void apply_button_will_be_visible_and_click_apply_button() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		MainCareerPage.clickbtn().click();
	}

	@Then("Verify validation for all fields under Personal details such as {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void verify_validation_for_all_fields_under_personal_details_such_as(String firstname, String lastname,
			String email, String mobno, String sport, String pet, String currentcity, String hometown, String dob)
			throws InterruptedException {

		Thread.sleep(3000);
		MainCareerPage.allfieldsvalidation(firstname, lastname, email, mobno, sport, pet, currentcity, hometown, dob);
	}

	@Then("Close the Browser")
	public void close_the_browser() {
		MainCareerPage.closeBroswer();
	}
}
