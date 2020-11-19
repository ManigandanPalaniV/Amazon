package org.amazon;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPage {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File srcPlace = screenshot.getScreenshotAs(OutputType.FILE);
		File dstPlace = new File("D:\\Mani\\Project\\Amazon\\HomePage.png");
		FileUtils.copyFile(srcPlace, dstPlace);

		WebElement txtSearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		txtSearch.sendKeys("One Plus", Keys.ENTER);
		
		TakesScreenshot screenshot1 = (TakesScreenshot)driver;
		File srcPlace1 = screenshot.getScreenshotAs(OutputType.FILE);
		File dstPlace1 = new File("D:\\Mani\\Project\\Amazon\\Products.png");
		FileUtils.copyFile(srcPlace1, dstPlace1);

		WebElement products = driver.findElement(By.xpath("//div[@id='search']"));
		String pro = products.getText();
		System.out.println(pro);

		driver.quit();

	}

}
