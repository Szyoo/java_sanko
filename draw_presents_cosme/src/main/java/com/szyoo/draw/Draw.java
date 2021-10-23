package com.szyoo.draw;

import java.util.List;

import com.szyoo.Driver;
import com.szyoo.InputController;
import com.szyoo.Present;

import org.openqa.selenium.WebDriver;

public class Draw {
    /**
     * 整体抽奖流程控制，包括遍历奖品链接以及单个完整抽奖
     * 
     * @param presents
     */
    public static void drawAll(WebDriver driver, List<Present> presents) {
        for (Present p : presents) {
            if (!p.getDrew()) { // 未过抽奖
                driver.get(p.getLink()); // 跳转奖品介绍界面
                if (!Draw.drawOnce(driver, p)) {
                    break;
                }
            }
        }
    }

    /**
     * 打开奖品介绍界面后，查找并点击募集按钮，点击进入填表，填写所有信息，点击送信
     * 
     * @param driver  Web驱动
     * @param present Present对象
     * @return ContinueFlag 根据用户输入需要终止全部抽奖流程时返回false
     */
    public static Boolean drawOnce(WebDriver driver, Present present) {
        // 尝试进入填表页面，若失败则跳过
        if (gotoFill(driver, present)) {
            Fill.fillQuestion(driver);
            Fill.fillName(driver);
            if (InputController.chekcContinue()) {
                Fill.send(driver, present);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 单个奖品抽奖流程开始后调用，尝试处理登录等特殊情况并到达填表界面
     * 
     * @param driver
     * @param present
     * @return 无法确认/已募集的情况下需要跳过，返回false，正常情况下返回true
     */
    public static boolean gotoFill(WebDriver driver, Present present) {
        int failCount = 0;
        do {
            // 四次循环内始终保证当前处于正确窗口
            Driver.switchNextWindow(driver);
            if (driver.getTitle().contains("ログイン／メンバー登録")) {
                // 如果需要登录则进行登录流程
                Login.login(driver);
            }
            try {
                // 尝试在找到募集按钮的情况下点击
                Find.findDrawBtn(driver).click();
                continue;
            } catch (Exception e) {
            }
            try {
                // 尝试在找到确认个人信息按钮的情况下点击
                Find.findToFillBtn(driver).click();
                continue;
            } catch (Exception e) {
            }
            if (Find.findDrew(driver)) {
                // 已募集的情况下终止本轮抽奖
                present.setDrew(true);
                return false;
            } else if (Find.findSendBtn(driver)) {
                // 找到填表界面内的送信按钮时返回true
                return true;
            }
        } while (++failCount > 3);
        System.out.println("奖品状态无法确认，尝试跳过！\n当前奖品信息：" + present.toString());
        return false;
    }
}