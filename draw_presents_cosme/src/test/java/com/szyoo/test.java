package com.szyoo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:\\seleniumDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.google.com/mail/u/0/");

        String title = driver.getTitle();
        System.out.println(title);

        driver.close();
    }
}
