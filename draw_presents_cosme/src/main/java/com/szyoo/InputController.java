package com.szyoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class InputController {
    public static Boolean chekcContinue() {
        System.out.println("完成，是否继续下一个抽奖？ y/n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (true) {
            try {
                input = br.readLine();
                if (input.equals("y") || input.equals("n")) {
                    br.close();
                    break;
                }
            } catch (Exception e) {
            }
            System.out.println("输入有误，请重新输入！");
        }
        if (input.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static void waitRefill() {
        System.out.println("送信失败，可能是有必填项目未填写，请检查浏览器并手动填写后在此输入 'ok' 以确认继续");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (true) {
            try {
                input = br.readLine();
                if (input.equals("ok")) {
                    br.close();
                    break;
                }
            } catch (Exception e) {
            }
            System.out.println("输入有误，请重新输入！");
        }
    }

    public static int chooseItem(List<Integer> numList) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = -1;
        while (true) {
            try {
                num = Integer.parseInt(br.readLine());
                if (numList.contains(num)) {
                    br.close();
                    return num;
                }
            } catch (Exception e) {
            }
            System.out.println("输入有误，请重新输入！");
        }
    }
}
