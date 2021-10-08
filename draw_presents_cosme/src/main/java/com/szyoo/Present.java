package com.szyoo;

import java.util.Date;

public class Present {
    private String link;
    private String name;
    private boolean isDrew;
    private Date scanDate;
    private Date drawDate;
    private static int callTimes = 0;

    @Override
    public String toString() {
        return "Present [drawDate=" + drawDate + ", isDrew=" + isDrew + ", link=" + link + ", name=" + name
                + ", scanDate=" + scanDate + "]";
    }

    public Present(String link, String name, boolean isDrew, Date scanDate) {
        this.link = link;
        this.name = name;
        this.isDrew = isDrew;
        this.scanDate = scanDate;
        this.drawDate = null;
        addCall();
    }

    private static void addCall() {
        callTimes++;
    }

    public static void showCall() {
        System.out.println("Total Count: "+ callTimes);
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

    public boolean isDrew() {
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

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }
}
