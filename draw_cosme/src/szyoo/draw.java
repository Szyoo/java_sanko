package szyoo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class draw {
    public static void main(String[] args) throws InterruptedException {
        ioFile file = new ioFile();
        
        System.setProperty("webdriver.chrome.driver", "c:\\seleniumDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users/student/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--profile-directory=Profile 6");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.cosme.net/present");
        Thread.sleep(3000);

        // List<WebElement> present_buttons =
        // driver.findElements(By.xpath("//a[contains(@href,
        // 'present/detail/present_id')]"));
        List<WebElement> present_buttons = driver.findElements(By.cssSelector("a[href*='present/detail/present_id']"));
        List<String> presents_link = new ArrayList<String>();
        for (WebElement e : present_buttons) {
            // System.out.println(e.getText().toString());
            // System.out.println(e.getAttribute("href").toString());
            presents_link.add(e.getAttribute("href").toString());
        }

        removeDuplicate(presents_link);// 给所有链接去重
        Map<String, Boolean> presents_used = pharseMap(presents_link);// 将链接储存为键值对

        driver.close();

        file.saveMapTXT(presents_used);
    }
    // <a href="/present/detail/present_id/18286" onclick="javascript:ga('send',
    // 'event', 'present', 'index', '05_gpre_b_01');"><img
    // src="https://cache-cdn.cosme.net/images/cnt/present/btn_apply.png"
    // width="122" height="22" alt="応募する"></a>
    // <a href="/present/detail/present_id/18284" onclick="javascript:ga('send',
    // 'event', 'present', 'index', '05_gpre_b_03');"><img
    // src="https://cache-cdn.cosme.net/images/cnt/present/btn_apply.png"
    // width="122" height="22" alt="応募する"></a>
    // *[@id="list-member"]/ul[1]/li[1]/dl/dd/p[2]/a

    private static void removeDuplicate(List<String> list) {
        List<String> result = new ArrayList<String>();
        for (String s : list) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        list.clear();
        list.addAll(result);
    }

    private static Map<String, Boolean> pharseMap(List<String> list) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for (String s : list) {
            map.put(s, false);
        }
        return map;
    }

    

}
