package week3.day5;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions build=new Actions(driver);
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		build.moveToElement(brand).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='scroller-container']/div[2]/a")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("L'Oreal Paris"))
			System.out.println("correct");
		else
			System.out.println("worng");
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("(//label[@class='control control-radio'])[4]")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String filter = driver.findElement(By.xpath("//span[text()='Shampoo']/parent::div")).getText();
		System.out.println(filter);
		if(filter.contains("Shampoo"))
			System.out.println("filter is applied");
		else
			System.out.println("filter is not applied");
		driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
		
//window handling...................................................................................................		
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		for (String string : s) {
			if (string != parent) {
				driver.switchTo().window(string);
			}
		}
//window handling...................................................................................................		
		
		WebElement gram = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dropdown=new Select(gram);
		dropdown.selectByVisibleText("175ml");
		String mrp = driver.findElement(By.xpath("(//span[text()='₹150'])[1]")).getText();
		System.out.println("MRP: "+mrp);
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']")).click();
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		String total = driver.findElement(By.xpath("(//span[text()='Grand Total'])[2]/following-sibling::div")).getText();
		System.out.println("Grand total: "+total);
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		String text = driver.findElement(By.xpath("//span[text()='220']/parent::div")).getText();
		if(total.equals(text))
			System.out.println("ok");
		else
			System.out.println("not ok");
		
		
		driver.quit();


	}	
}





