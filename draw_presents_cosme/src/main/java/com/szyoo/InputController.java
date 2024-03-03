package com.szyoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class InputController {
    public static Boolean checkContinue() {
        System.out.println("完成，是否继续下一个抽奖？ y/n");
        String input = "";
        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                input = br.readLine();
                if (input.equals("y") || input.equals("n")) {
                    // br.close();
                    if (input.equals("y")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("输入有误，请重新输入！");
        }
    }

    public static void waitRefill() {
        System.out.println("\n！！！Oooops！！！\n送信失败，可能是有必填项目未填写，请检查浏览器并手动填写后在此输入 'ok' 以确认继续\n！！！Oooops！！！");
        System.out.print(">  ");
        String input = "";
        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                input = br.readLine();
                if (input.equals("ok")) {
                    // br.close();
                    return;
                }
            } catch (Exception e) {
            }
            System.out.println("输入有误，请重新输入！");
        }
    }

    public static int chooseItem(List<Integer> numList) {
        int num = -1;
        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                num = Integer.parseInt(br.readLine());
                if (numList.contains(num)) {
                    // br.close();
                    return num;
                }
            } catch (Exception e) {
            }
            System.out.println("输入有误，请重新输入！");
        }
    }

    /**
     * 询问用户是否跳过超过3个月未抽取的奖品
     * 
     * @return 用户选择跳过返回true，否则返回false
     */
    public static boolean askToSkipOldPresent() {
        System.out.println("该奖品已超过3个月未被抽取。是否跳过此奖品并标记为已抽取？(y/n)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (true) {
            try {
                input = br.readLine();
                if ("y".equalsIgnoreCase(input)) {
                    return true; // 用户选择跳过
                } else if ("n".equalsIgnoreCase(input)) {
                    return false; // 用户选择不跳过
                } else {
                    System.out.println("输入有误，请输入'y'或'n'！");
                }
            } catch (Exception e) {
                System.out.println("读取输入时出错，请重新输入！");
            }
        }
    }
}
