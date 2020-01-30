package Exceliteration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Main extends Base {
	public static void main(String[] args) throws Throwable {
		launchBrowser();
		loadurl("https://facebook.com/");
		getTitle();
		getCurrentUrl();
		WebElement user = driver.findElement(By.id("email"));
		fill(user,getDatafromExcel(1, 0));
		WebElement pas = driver.findElement(By.id("pass"));
		fill(pas,getDatafromExcel(2, 0));
		
		WebElement button = driver.findElement(By.id("loginbutton"));
		buttonClick(button);
		quit();

	}

}

