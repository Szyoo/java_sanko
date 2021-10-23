package com.szyoo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

import com.szyoo.draw.Draw;
import com.szyoo.draw.Find;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     * 
     * @throws IOException
     */
    @Test
    void testApp() throws IOException {
        WebDriver driver = Driver.setDriver();
        String link = "https://as.iy.impact-ad.jp/ct?id=344022";

        driver.get(link);
        Driver.closeOtherWindow(driver);

        Present p = new Present();
        p.setLink(link);

        Draw.drawOnce(driver, p);

    }

    @Test
    void countBtn() {
        WebDriver driver = Driver.setDriver();
        List<Present> presents = Find.searchPresentToList(driver);
        countDrawBtn(presents, driver);
        Present.showCall();
    }

    /**
     * 遍历传入Present对象的List的对应页面后统计找到的募集按钮数量
     * 
     * @param list
     * @param driver
     */
    private void countDrawBtn(List<Present> list, WebDriver driver) {
        int success = 0;
        int fail = 0;
        int drew = 0;

        for (Present p : list) {
            driver.get(p.getLink());// 进入对应奖品的介绍界面
            if (Find.findDrawBtn(driver) != null) {
                System.out.println("Gotcha!");
                success++;
            } else if (Find.findDrew(driver)) {
                System.out.println("Already Drew!");
                drew++;
            } else {
                System.out.println("/@Test: Draw Btn not Found!\n" + p.toString());
                fail++;
            }
        }
        System.out.println("Result [fail=" + fail + ", sucess=" + success + ", drew=" + drew + ", total:"
                + (success + fail + drew) + "]");
    }
}
