package ultimateqaTest.SeleniumUltimate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TestUltimate 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://ultimateqa.com/automation");
        driver.manage().window().maximize();
        
        //Big page with many elements
        driver.findElement(By.xpath("//*[@id=\"post-507\"]/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/ul/li[1]/a")).click();
        
        for(int i=1; i<=4;i++) {
        	for(int j=1;j<=3;j++) {
        		
        		WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[3]/div["+i+"]/div["+j+"]/a"));
        		
        		actions.moveToElement(button).perform();
        		System.out.println("Button "+i+" "+j+" is available.");
        		
        		Thread.sleep(1000);
        	}
        }

		for (int i=1; i<=2; i++) {
			for (int j=1; j<=5; j++) {
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[5]/div["+i+"]/ul["+j+"]/li/a")).click();
				String url = driver.getCurrentUrl();
				System.out.println("Current URL is: " + url);
				String[] arrOfStr = url.split("/");
				System.out.println("Name of site: " + arrOfStr[2]);
				Thread.sleep(2000);
				if( url.contains("twitter")) {
					System.out.println("This site is "+ driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[1]/div[1]/div/div/div/div/div/div[2]/div/h2/div/div/div/div/span[1]/span/span[1]")).getText());
				}
				driver.navigate().back();
				Thread.sleep(2000);
			}
		}	
		
		driver.findElement(By.id("et_pb_contact_name_0")).sendKeys("YourName");
		driver.findElement(By.id("et_pb_contact_email_0")).sendKeys("youremail@address.com");
		driver.findElement(By.id("et_pb_contact_message_0")).sendKeys("Your message in this form.");
		String equation = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[7]/div[2]/div[1]/div[2]/form/div/div/p/span")).getText();
		String[] arrOfEqt = equation.split(" ");
		int result = 0;
		
		switch(arrOfEqt[1]) {
		case "+":
			result = Integer.parseInt(arrOfEqt[0])+Integer.parseInt(arrOfEqt[2]);
			break;
		case "-":
			result = Integer.parseInt(arrOfEqt[0])-Integer.parseInt(arrOfEqt[2]);
			break;
		case "/":
			result = Integer.parseInt(arrOfEqt[0])/Integer.parseInt(arrOfEqt[2]);
			break;
		case "*":
			result = Integer.parseInt(arrOfEqt[0])*Integer.parseInt(arrOfEqt[2]);
			break;
		}
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[7]/div[2]/div[1]/div[2]/form/div/div/p/input")).sendKeys(Integer.toString(result));
		driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]/div[2]/form/div/button")).click();
		
		driver.findElement(By.id("user_login_649bd97def026")).sendKeys("yourLogin");
		driver.findElement(By.id("user_pass_649bd97def026")).sendKeys("yourPassword");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[7]/div[2]/div[2]/div[2]/form/p[4]/button")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[7]/div[2]/div[3]/h5")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div[7]/div[2]/div[3]/h5")).click();
		
		
		
    }
    
   
    	
    
}
