package simpleMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Maven {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\desk\\eclipse-selenium\\Simplemaven\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://snapdeal.com/");
	}
	

}
