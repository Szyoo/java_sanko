package com.szyoo;

import java.util.List;

import javax.swing.JFrame;

import com.szyoo.draw.Draw;
import com.szyoo.draw.Find;
import com.szyoo.gui.SwingGUI;
import com.szyoo.jackson.JsonConverter;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {

        // JFrame frame = new SwingGUI("@COSME 抽奖程序");
        // frame.setVisible(true);

        // WebDriver driver = Driver.setDriverChrome();
        // WebDriver driver = Driver.setDriverEdge();
        WebDriver driver = Driver.setDriverFirefox();

        System.out.println("\n\n<<<<<<<<<<<<<<<<<<<<<<<<<<\n| Welcome to Take a Shot |\n>>>>>>>> (￣ω￣= >>>>>>>>>\n");

        List<Present> presents = JsonConverter.updateList(Find.searchPresentToList(driver));

        Draw.drawAll(driver, presents);

        System.out.println("本次抽奖流程完成\n总计抽取奖品: " + Present.showDraw() + " 次");

        JsonConverter.writeJsonFile(presents);
        driver.close();

        System.out.println("程序即将退出，祝你好运～ (￣ω￣=");
    }
}
