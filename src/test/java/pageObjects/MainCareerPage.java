package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MainCareerPage {
	public static WebDriver driver;

	public static WebElement headertxt() {
		return driver.findElement(By.xpath("//*[text()='JOIN OUR CREW']"));
	}

	public static String msg() {
		String text = driver.findElement(By.xpath("//td [@colspan='5']")).getText();
		return text;
	}

	public static WebElement clickonQA() {
		WebElement clickonQA = driver.findElement(By.xpath("(//*[text()='QA Engineer'])[1]"));
		return clickonQA;
	}

	public static String getURL() {
		return driver.getCurrentUrl();
	}

	public static void hoveronQA() {
		Actions actions = new Actions(driver);
		WebElement hover = driver.findElement(By.xpath("//a [@href=\"/careers/qa-engineer.php\"]"));
		actions.moveToElement(hover).perform();
	}

	public static WebElement clickbtn() {
		return driver.findElement(By.xpath("(//button [@class='btn btn-red-outline scroll-form'])[10]"));
	}

	public static void allfieldsvalidation(String firstName, String lastName, String email, String phone, String sport,
			String pet, String currentcity, String hometown, String dob) {

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);

		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);

		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);

		WebElement sportElement = driver.findElement(By.xpath("//select[@id=\"sports\"]"));
		Select s = new Select(sportElement);
		s.selectByVisibleText(sport);

		WebElement petElement = driver.findElement(By.xpath("//select[@id='pets']"));
		s = new Select(petElement);
		s.selectByVisibleText(pet);

		driver.findElement(By.xpath("//input[@id='current_city']")).sendKeys(currentcity);

		driver.findElement(By.xpath("//input[@id='hometown']")).sendKeys(hometown);

		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dob);

		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(Keys.ENTER);

	}

	public static void closeBroswer() {

		driver.quit();
		System.out.println("***All given test steps performed Sucessfully***");
	}
}
