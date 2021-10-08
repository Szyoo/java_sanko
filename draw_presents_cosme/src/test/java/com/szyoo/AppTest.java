package com.szyoo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {        
        WebDriver driver = draw.setDriver();
        driver.get("https://www.cosme.net/present/detail/present_id/18286");

        // List<WebElement> present_buttons =
        // driver.findElements(By.xpath("//a[contains(@href,
        // 'present/detail/present_id')]"));
        try {
            WebElement present_special = driver.findElement(By.className("btn-green"));
            present_special.click();
        } catch (Exception e) {
            WebElement drew_present = driver.findElement(By.className("apply-after"));
            System.out.println(drew_present.getText());
        }
    }
}
