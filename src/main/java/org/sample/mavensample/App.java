package org.sample.mavensample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

    public static void main(String[] args) {
        // telling Selenium about ChromeDriver location
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\future\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        // creating an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

     
            // here I'm initializing google home page URL
            String googleUrl = "https://www.google.com/";
            
            // using the driver to open google home page
            driver.get(googleUrl);

            // maximize the browser window
            driver.manage().window().maximize();

            // here I used the search box id to get it
            WebElement searchBox = driver.findElement(By.id("APjFqb"));

            // in the line below is the web site to be opened 
            searchBox.sendKeys("ritaj birzeit");

            // submitting the search request or clicking the search button automatically 
            searchBox.submit();


            // here I'm storing all search results in a list (I found out that google uses h3 inside a for results)
            List<WebElement> searchResults = driver.findElements(By.cssSelector("h3"));


            // loop to iterate the search result and store their URLs
            for (int i = 0; i < searchResults.size(); i++) {
            	if(i == 1) {
            		break;
            	}
            	// go to the parent <a> tag
                WebElement parent = searchResults.get(i).findElement(By.xpath("..")); 
                
             // get the URL from the href attribute
                String url = parent.getAttribute("href"); 

                // print the URL of the first search result
                System.out.println("URL of first search result: " + url);
                
            }
            
            //System.out.println("URL of search result: " + searchResultUrls[0]);

            try {
                Thread.sleep(3000);  // 3 seconds delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // close the browser
            driver.quit();
        
    }
}
