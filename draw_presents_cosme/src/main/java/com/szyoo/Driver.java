package com.szyoo;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    /**
     * 设置Driver路径，并代入默认option参数启动Chrome
     * 
     * @return WebDriver
     */
    public static WebDriver setDriver() {
        try {
            System.setProperty("webdriver.chrome.driver", "chromedriver_94.exe");

            ChromeOptions options = new ChromeOptions();

            // options.addArguments("--user-data-dir=C:\\Users/student/AppData/Local/Google/Chrome/User
            // Data");
            // options.addArguments("--profile-directory=Profile 6");

            options.addArguments("--user-data-dir=C:\\Users/losin/AppData/Local/Google/Chrome/User Data");
            options.addArguments("--profile-directory=Default");

            return new ChromeDriver(options);
        } catch (Exception e) {
            System.out.println("驱动加载失败，请关闭当前所有已开启的Chrome浏览器后重新运行程序");
            System.exit(0);
        }
        return null;
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
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(driver.getWindowHandle())) {
                // 切换到下一个窗口句柄
                driver.switchTo().window(window);
            }
        }
    }
}
