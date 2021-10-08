package com.szyoo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class draw {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = setDriver();
        driver.get("https://www.cosme.net/present");

        // List<WebElement> present_buttons =
        // driver.findElements(By.xpath("//a[contains(@href,
        // 'present/detail/present_id')]"));
        List<WebElement> presents_special = driver.findElements(By.cssSelector("a[href*='present/detail/present_id']"));
        List<WebElement> presents_normal = driver.findElements(By.cssSelector("a[href*='/as.iy.impact-ad.jp/ct?id=']"));
        List<Present> presents = new ArrayList<Present>();

        addElement(presents_special, presents);
        addElement(presents_normal, presents);

        // driver.get("https://www.cosme.net/brandfanclub/present");
        // List<WebElement> presents_bfc =
        // driver.findElements(By.className("psnt-btn"));

        checkDrawBtn(presents, driver);
        Present.showCall();

        // file.saveTXT();
        driver.close();
    }
    // <a href="/present/detail/present_id/18286" onclick="javascript:ga('send',
    // 'event', 'present', 'index', '05_gpre_b_01');"><img
    // src="https://cache-cdn.cosme.net/images/cnt/present/btn_apply.png"
    // width="122" height="22" alt="応募する"></a>
    // <a href="/present/detail/present_id/18286" onclick="javascript:ga('send',
    // 'event', 'present', 'index', '05_gpre_01');">【Ｗチャンスあり！】スパークルカラーコレクション
    // ムーンリバー</a>
    // <a href="/present/detail/present_id/18286" onclick="javascript:ga('send',
    // 'event', 'present', 'index', '05_gpre_b_01');"><img
    // src="https://cache-cdn.cosme.net/images/cnt/present/btn_apply.png"
    // width="122" height="22" alt="応募する"></a>
    // <a href="/present/detail/present_id/18284" onclick="javascript:ga('send',
    // 'event', 'present', 'index', '05_gpre_b_03');"><img
    // src="https://cache-cdn.cosme.net/images/cnt/present/btn_apply.png"
    // width="122" height="22" alt="応募する"></a>
    // *[@id="list-member"]/ul[1]/li[1]/dl/dd/p[2]/a

    public static void addElement(List<WebElement> list, List<Present> des) {
        for (WebElement e : list) {
            String text = e.getText().toString();
            if (!text.replaceAll(" ", "").equals("")) {
                des.add(new Present(e.getAttribute("href").toString(), text, false, new Date()));
            }
        }
    }

    public static WebDriver setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver_94.exe");
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--user-data-dir=C:\\Users/student/AppData/Local/Google/Chrome/User
        // Data");
        // options.addArguments("--profile-directory=Profile 6");
        options.addArguments("--user-data-dir=C:\\Users/losin/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--profile-directory=Default");
        return new ChromeDriver(options);
    }

    public static void findBtn(String className) {
        
    }
    public static void checkDrawBtn(List<Present> list, WebDriver driver) {
        int sucess = 0;
        int fail = 0;
        int newV = 0;
        int oldV = 0;
        int wchance = 0;
        int drew = 0;

        for (Present p : list) {
            driver.get(p.getLink());// 进入对应奖品的介绍界面
            try {
                driver.findElement(By.className("bt-article-link"));// 查找旧版PC入口链接
                System.out.println("OldVersion Gotcha!");
                oldV++;
                sucess++;
            } catch (Exception e) {
                try {
                    driver.findElement(By.className("gatrack"));// 查找新版图片按钮
                    System.out.println("NewVersion Gotcha!");
                    newV++;
                    sucess++;
                } catch (Exception e1) {
                    try {
                        driver.findElement(By.className("btn-green"));// 查找Wchance募集按钮
                        System.out.println("WChance Gotcha!");
                        wchance++;
                        sucess++;
                    } catch (Exception e2) {
                        try {
                            driver.findElement(By.className("apply-after"));// 查找已募集按钮
                            System.out.println("WChance Gotcha!");
                            drew++;
                        } catch (Exception e3) {
                            System.out.println(p.toString() + "\nDraw Link not Found!");
                            fail++;
                        }
                    }
                }
            }
        }
        System.out.println("Result [fail=" + fail + ", sucess=" + sucess + ", old=" + oldV + ", new=" + newV
                + ", wchance=" + wchance + ", drew=" + drew + ", total:" + (sucess + fail + drew) + "]");
    }

}
