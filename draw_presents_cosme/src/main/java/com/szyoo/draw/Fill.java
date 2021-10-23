package com.szyoo.draw;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.szyoo.InputController;
import com.szyoo.Present;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Fill {
    /**
     * 填表完成后调用，点击送信按钮并判断处理送信结果
     * 
     * @param driver
     * @param present
     */
    public static void send(WebDriver driver, Present present) {
        try {
            driver.findElement(By.cssSelector("input[alt=送信]")).click();
            if (checkSend(driver)) {
                present.setDrew(true);
                present.setDrawDate(new Date());
            } else {
                // 送信失败，可能是有必填项目未填写，手动填写后在控制台确认
                InputController.waitRefill();
                send(driver, present);
            }
        } catch (Exception e) {
            System.out.println("送信按钮查找失败");
        }
    }

    private static Boolean checkSend(WebDriver driver) {
        if (Find.findDrew(driver)) {
            return true;
        } else if (Find.findSendBtn(driver)) {
            try {
                driver.findElement(By.cssSelector("input[alt=送信]")).click();
            } catch (Exception e) {
            }
        }
        return false;
    }

    /**
     * 抽奖流程中调用，自动完成填写名字前的填表流程
     * 
     * @param driver
     * @return boolean 完成后返回true
     */
    public static boolean fillQuestion(WebDriver driver) {
        List<String> keyword = new ArrayList<String>();
        keyword.add("クレンジング料");
        keyword.add("化粧水");
        keyword.add("乳液");
        keyword.add("クリーム");
        keyword.add("アイクリーム・ジェル");
        keyword.add("デパート・百貨店");
        keyword.add("化粧品専門店");
        keyword.add("ドラッグストア");
        keyword.add("乾燥肌");
        keyword.add("ウォーター・ミスト");
        keyword.add("ボディクリーム");
        keyword.add("保湿");
        keyword.add("乾燥を防ぐ");
        keyword.add("興味がある");
        keyword.add("うるおい");
        keyword.add("低刺激");
        keyword.add("とても満足");
        keyword.add("使用したことはない");
        keyword.add("を与える");
        keyword.add("透明感");
        keyword.add("嬉しい");
        keyword.add("わからない");
        keyword.add("00円以上");
        keyword.add("応募にあたり、選択したブランドを「お気に入り登録」します");
        keyword.add("非常に傷んでいる");
        keyword.add("シャンプー");
        keyword.add("洗い流すトリートメント（ポンプタイプ）");
        keyword.add("リンス・コンディショナー");
        keyword.add("仕上がり");
        keyword.add("気になることがある");
        keyword.add("アイブロウ");
        keyword.add("アイライナー");
        keyword.add("アイシャドウ");
        keyword.add("チーク");
        keyword.add("口紅");
        keyword.add("長さが出る");
        keyword.add("ボリューム");
        keyword.add("自然");
        keyword.add("セミロング");
        keyword.add("香りが好き");
        keyword.add("乾燥");
        keyword.add("ニキビ");
        keyword.add("しっかり落としたい");
        keyword.add("新しい商品はすぐに試してみたい");
        keyword.add("試すのが好きだ");
        keyword.add("信頼できるメーカーやブランド");
        keyword.add("ダメージをケアする");
        keyword.add("洗い流すトリートメント");
        keyword.add("美容成分配合である");
        keyword.add("美容液成分であるヘアケアアイテムは魅力的だ");
        keyword.add("ペンシルタイプ");
        keyword.add("リキッドタイプ");
        keyword.add("細くも太くも描ける");
        keyword.add("描きやすい");
        keyword.add("ボディソープ（泡で出てくるタイプ）");
        keyword.add("手洗い");
        keyword.add("スポンジ");
        keyword.add("水や汗に強い");
        keyword.add("白くならない");
        keyword.add("日焼けしない");
        keyword.add("肌に負担のない");
        keyword.add("肌に優しい");
        keyword.add("1回程度");
        keyword.add("ネイルカラー");
        keyword.add("やや敏感");
        keyword.add("施術を受けたことはないし、興味もない");
        keyword.add("ときどきある");
        keyword.add("冷たいものがしみる");
        keyword.add("ムシ歯になりやすい");
        keyword.add("肌がしっとりする");
        keyword.add("顔や体に「日焼け止め」を使用");
        keyword.add("標準色");
        keyword.add("1回程度");
        keyword.add("1回程度");
        List<WebElement> list = driver.findElements(By.cssSelector("td>span>label"));
        for (WebElement label : list) {
            for (String key : keyword) {
                // 若Label中存在指定关键词则点击其下属的input
                if (label.getText().contains(key)) {
                    label.findElement(By.cssSelector("input")).click();
                }
            }
        } // *[contains(@class,'article-item box-image banner')]/a
        try {
            driver.findElement(By.xpath("//label[contains(.,'使用したことはないが、興味はある')]")).findElement(By.cssSelector("input"))
                    .click();
        } catch (Exception e) {
        }
        try {
            // 定位商品选择文字td的父元素tr的下一个，即商品选择所在tr
            WebElement itemChoiceTR = driver
                    .findElement(By.xpath("//td[contains(.,'ご希望の')]/../following-sibling::tr[1]"));
            // 定位所有input选择框
            List<WebElement> itemList = itemChoiceTR.findElements(By.cssSelector("td>span>label>input"));
            System.out.println("存在多个奖品可选择，请输入对应编号选择");

            List<String> content = new ArrayList<String>();
            List<Integer> choiceNum = new ArrayList<Integer>();
            for (WebElement w : itemList) {
                String str = w.findElement(By.xpath("./..")).getText();
                content.add(str);
                choiceNum.add(content.indexOf(str) + 1);
                // 打印No.编号（input中的value值）
                System.out.println("No." + (content.indexOf(str) + 1) + " :" + str);
            }
            int num = InputController.chooseItem(choiceNum);
            for (WebElement w : itemList) {
                if (w.findElement(By.xpath("./..")).getText().equals(content.get(num - 1))) {
                    w.click();
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    /**
     * 填表流程中调用，自动填写个人信息相关信息
     * 
     * @param driver
     * @return boolean 完成后返回true
     */
    public static boolean fillName(WebDriver driver) {
        String[] str = { "名前", "王韻雅", "年齢", "25" };
        for (int i = 0; i < str.length; i += 2) {
            try {
                // 定位指定文字td的下一个td，即input所在td
                WebElement inputTd = driver
                        .findElement(By.xpath("//td[contains(.,'" + str[i] + "')]/following-sibling::td[1]"));
                // 定位到该td下的input
                WebElement input = inputTd.findElement(By.cssSelector("td>span>input"));
                input.clear();
                input.sendKeys(str[i + 1]);
            } catch (Exception e) {
                System.out.println("查找" + str[i] + "输入框失败");
                return false;
            }
        }
        try {
            Select select = new Select(driver.findElement(By.cssSelector("select[name=prof_010_job1]")));
            select.selectByVisibleText("自営業/自由業");
        } catch (Exception e) {
            System.out.println("查找职业输入框失败");
            return false;
        }
        return true;
    }
}
