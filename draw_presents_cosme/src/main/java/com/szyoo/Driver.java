package com.szyoo;

import java.awt.*;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
    /**
     * 设置Driver路径，并代入默认option参数启动Chrome
     * 
     * @return WebDriver
     */

    public static WebDriver driver = setDriverChrome();
    // WebDriver driver = setDriverEdge();
    // WebDriver driver = setDriverFirefox();

    public static WebDriver setDriverChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Dimension halfScreenSize = getHalfScreenSize();
        // 使用获取的屏幕尺寸设置浏览器窗口大小和位置
        options.addArguments("window-size=" + halfScreenSize.width + "," + halfScreenSize.height);
        options.addArguments("window-position=0,0");
        return new ChromeDriver(options);
    }

    public static WebDriver setDriverEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        return new EdgeDriver(options);
    }

    public static WebDriver setDriverFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }

    private static Dimension getHalfScreenSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int halfWidth = screenSize.width / 2;
        int fullHeight = screenSize.height;
        return new Dimension(halfWidth, fullHeight);
    }

    /**
     * 关闭当前窗口以外的所有窗口
     * 
     * @param driver
     */
    public static void closeOtherWindow(WebDriver driver) {
        String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
        Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
        for (String w : handles) {
            if (!w.equals(currentWindow)) {// 获取到的窗口句柄不同于初始窗口
                driver.switchTo().window(w);// 切换到该窗口句柄
                driver.close();// 关闭当前切换到的窗口
            }
        }
        driver.switchTo().window(currentWindow);
    }

    /**
     * 切换到当前能识别的下一个窗口
     * 
     * @param driver
     */
    public static void switchNextWindow(WebDriver driver) {
        // 获取所有窗口句柄
        String handle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String window : handles) {
            if (!window.equals(handle)) {
                // 关闭当前窗口
                driver.close();
                // 切换到下一个窗口句柄
                driver.switchTo().window(window);
            }
        }
    }
}
