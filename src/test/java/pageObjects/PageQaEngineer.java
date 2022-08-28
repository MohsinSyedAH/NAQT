package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageQaEngineer {
	public static WebDriver driver;

	public static WebElement verifyandClickBtn() {
		String text = driver.findElement(By.xpath("//a[@href='/careers#careersFormContainer']")).getText();
		if (text.equals("Apply here now")) {
			System.out.println(text + " Button is Verifed");
		} else {
			System.out.println(text + " is Not Verifed");
		}

		return driver.findElement(By.xpath("//a[@href='/careers#careersFormContainer']"));
	}

	public static String getURL() {
		return driver.getCurrentUrl();
	}

}
