package week3.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sorable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement option1 = driver.findElement(By.xpath("//ul/li[text()='Item 2']"));
		WebElement option2 = driver.findElement(By.xpath("//ul/li[text()='Item 5']"));
		Actions build=new Actions(driver);
		//build.clickAndHold(option1).moveToElement(option2).build().perform();
		//build.clickAndHold(option2).moveToElement(option1).build().perform();
		build.clickAndHold(option1).moveToElement(option2).build().perform();
		build.clickAndHold(option2).moveToElement(option1).build().perform();
		
	}

}
