package com.szyoo.draw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    /**
     * 登陆流程，需要时调用
     * 
     * @param driver
     * @return boolean 完成后返回true
     */
    public static boolean login(WebDriver driver) {
        try {
            driver.findElement(By.className("em-placeholder")).sendKeys("losiner.y@gmail.com");
            driver.findElement(By.className("input-password em-placeholder js-password")).sendKeys("ysz960411");
            driver.findElement(By.className("button-submit")).click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
