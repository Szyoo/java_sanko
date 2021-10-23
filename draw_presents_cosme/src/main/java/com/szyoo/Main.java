package com.szyoo;

import java.util.List;

import com.szyoo.draw.Draw;
import com.szyoo.draw.Find;
import com.szyoo.jackson.JsonConverter;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = Driver.setDriver();

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<\n| Welcome to Take a Shot |\n>>>>>>>> (￣ω￣= >>>>>>>>>");

        List<Present> presents = JsonConverter.updateList(Find.searchPresentToList(driver));

        Draw.drawAll(driver, presents);

        System.out.println("本次抽奖流程完成\n总计抽取奖品: " + Present.showDraw() + " 次");

        JsonConverter.writeJsonFile(presents);
        driver.close();

        System.out.println("程序即将退出，祝你好运～ (￣ω￣=");
    }
}
