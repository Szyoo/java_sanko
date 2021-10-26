package com.szyoo.draw;

import java.util.ArrayList;
import java.util.List;

import com.szyoo.Driver;
import com.szyoo.Present;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Find {
    /**
     * 在已打开页面上查找所有可用奖品信息，并将[链接，文本，当前时间]汇总为Present的List
     * 
     * @param driver
     * @return
     */
    public static List<Present> searchPresentToList(WebDriver driver) {
        System.out.println("开始识别奖品...\n请稍等...");
        driver.get("https://www.cosme.net/present");
        Driver.closeOtherWindow(driver);

        List<WebElement> presents_special = driver.findElements(By.cssSelector("a[href*='present/detail/present_id']"));
        List<WebElement> presents_normal = driver.findElements(By.cssSelector("a[href*='/as.iy.impact-ad.jp/ct?id=']"));

        List<Present> presents = new ArrayList<Present>();

        Present.addElement(presents_special, presents);
        Present.addElement(presents_normal, presents);

        driver.get("https://www.cosme.net/brandfanclub/present");
        Driver.closeOtherWindow(driver);

        List<WebElement> presents_brand = driver.findElements(
                By.cssSelector("div[class=psnt]>ul[class=clearfix]>li>a[href*='cosme.net/brand/brand_id']"));
        Present.addElement(presents_brand, presents);
        System.out.println("识别完成！共识别到奖品：" + Present.getCall() + " 个");
        return presents;
    }

    /**
     * 通过Xpath查找元素，成功返回元素对象，失败返回null
     * 
     * @param xpath路径
     */
    private static WebElement findByXpath(WebDriver driver, String xpath) {
        WebElement btn = null;
        try {
            btn = driver.findElement(By.xpath(xpath));
            return btn;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 在奖品一级介绍界面查找募集按钮，找到了返回WebElement，未找到则返回值为null的WebElement
     * 
     * @param driver
     * @return WebElement 按钮对象或者Null
     * 
     */
    public static WebElement findDrawBtn(WebDriver driver) {
        List<String> xpaths = new ArrayList<String>();
        xpaths.add("btn-green");
        xpaths.add("//a[contains(.,'こちら') and contains(@rel,'nofollow')]");
        xpaths.add("//p[contains(text(),'すぐ応募')]");
        xpaths.add("//p[contains(.,'応募する')]");
        xpaths.add("//p[@class='apply']/input[@value='応募する']"); // WChance的绿色募集按钮
        xpaths.add("//a[contains(.,'すぐ応募')]");
        xpaths.add("//*[contains(@class,'article-item box-image banner')]/a");
        xpaths.add("//a[contains(.,'PCから応募')]");
        xpaths.add("//img[contains(@src,'037_123_original_pc_bt4.png')]");
        xpaths.add("//span[contains(text(),'応募する')]");

        WebElement btn = null;
        for (String xpath : xpaths) {
            btn = findByXpath(driver, xpath);
            if (btn != null) {
                return btn;
            }
        }
        return null;
    }

    /**
     * 在点击募集后进入的个人信息确认界面查找确认募集按钮，找到了返回WebElement，未找到则返回值为null的WebElement
     * 
     * @param driver
     * @return WebElement 按钮对象或者Null
     * 
     */
    public static WebElement findToFillBtn(WebDriver driver) {
        List<String> xpaths = new ArrayList<String>();
        xpaths.add("//input[@value='次へ進む']");
        xpaths.add("//p[@class='present-apl-btn']/input[@value='応募する']");
        // xpaths.add("");

        WebElement btn;
        for (String xpath : xpaths) {
            btn = findByXpath(driver, xpath);
            if (btn != null) {
                return btn;
            }
        }
        return null;
    }

    /**
     * 查找已募集按钮或者已募集标签
     * 
     * @param driver
     * @return 找到了返回true，未找到则返回false
     */
    public static Boolean findDrew(WebDriver driver) {
        List<String> xpaths = new ArrayList<String>();
        xpaths.add("//*[contains(text(),'応募済み')]");
        xpaths.add("//*[contains(text(),'すでに回答済')]");
        xpaths.add("//*[@class='apply-after']");
        // xpaths.add("");

        WebElement btn = null;
        for (String xpath : xpaths) {
            btn = findByXpath(driver, xpath);
            if (btn != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找送信按钮
     * 
     * @param driver
     * @return 找到了返回true，未找到则返回false
     */
    public static Boolean findSendBtn(WebDriver driver) {
        String xpath = "//input[@alt='送信']";
        WebElement btn = findByXpath(driver, xpath);
        if (btn != null) {
            return true;
        }
        return false;
    }

    public static boolean findFillFailed(WebDriver driver) {
        return false;
    }

}
