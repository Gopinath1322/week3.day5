package week3.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement opt1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement opt2 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement opt3 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		Actions build=new Actions(driver);
		build.keyDown(Keys.CONTROL).click(opt1).click(opt2).click(opt3).release().perform();
	}

}
