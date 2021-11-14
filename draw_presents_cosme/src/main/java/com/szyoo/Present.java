package com.szyoo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Present {
    private String link;
    private String name;
    private boolean isDrew;
    private Date scanDate;
    private Date drawDate;
    private static int callTimes = 0;
    private static int drawTimes = 0;

    @Override
    public String toString() {
        return "Present [drawDate=" + drawDate + ", isDrew=" + isDrew + ", link=" + link + ", name=" + name
                + ", scanDate=" + scanDate + "]";
    }

    public Present() {
    }

    public Present(String link, String name, boolean isDrew, Date scanDate) {
        this.link = link;
        this.name = name;
        this.isDrew = isDrew;
        this.scanDate = scanDate;
        this.drawDate = null;
        countCall();
    }

    private static void countCall() {
        callTimes++;
    }

    public static void showCall() {
        System.out.println("Total Count: " + callTimes);
    }

    public static int getCall() {
        return callTimes;
    }

    public static void countDraw() {
        drawTimes++;
    }

    public static int showDraw() {
        return drawTimes;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getDrew() {
        return isDrew;
    }

    public void setDrew(boolean isDrew) {
        this.isDrew = isDrew;
    }

    public Date getScanDate() {
        return scanDate;
    }

    public void setScanDate(Date scanDate) {
        this.scanDate = scanDate;
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate() {
        this.drawDate = new Date();
    }

    /**
     * 合并两个Present对象List，旧数据drew覆盖新数据，并去除重复
     * 
     * @param presents_new
     * @param presents_old
     * @return
     */
    public static List<Present> unionPresent(List<Present> presents_new, List<Present> presents_old) {
        List<Present> result = new ArrayList<Present>();
        int unionCount = 0;
        int ununionCount = 0;
        for (Present p_new : presents_new) {
            Boolean unionFlag = false;
            for (Present p_old : presents_old) {
                if (p_old.getLink().equals(p_new.getLink())) {// 存在相同链接对象
                    result.add(p_old);// 将文件内存储的对象覆盖到当前List
                    unionFlag = true;
                    unionCount++;
                    break;
                }
            }
            if (!unionFlag) {// 当前新增对象不包含在文件内
                result.add(p_new);
                ununionCount++;
            }
        }
        System.out.println("数据整合成功！");
        System.out.println("读取到的旧数据共：" + presents_old.size() + " 条");
        System.out.println("整合之后的数据共：" + result.size() + " 条：");
        System.out.println("其中包含: 旧数据沿用: " + unionCount + "条，新增数据: " + ununionCount + "条");
        return result;
    }

    /**
     * 将WebElement内的链接，文本，当前时间赋予Present对象并组成List
     * 
     * @param list 待转换的WebElement对象List
     * @param des  目标Present对象List
     */
    public static void addElement(List<WebElement> list, List<Present> des) {
        for (WebElement e : list) {
            String text = "";
            try {
                text = e.getText().toString();
            } catch (Exception e0) {
                try {
                    text = e.findElement(By.xpath("//span[@class='psnt-ttl']")).getText().toString();
                } catch (Exception e1) {
                }
            }
            if (!text.replaceAll(" ", "").equals("")) {
                des.add(new Present(e.getAttribute("href").toString(), text, false, new Date()));
            }
        }
    }
}
