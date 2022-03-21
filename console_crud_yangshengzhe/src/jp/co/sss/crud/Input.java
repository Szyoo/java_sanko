package jp.co.sss.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Input {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    private static int inputNum() throws NumberFormatException, IOException {
        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String context = br.readLine();
        if (context.equals("")) {
            // 未入力の場合
            return 0;
        } else {
            // 入力したStringをIntに転換する
            int num = Integer.parseInt(context);
            return num;
        }
    }

    private static String inputString() throws IOException {
        // 標準入力
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String context = br.readLine();
        if (context.equals("")) {
            // 未入力の場合
            return null;
        } else {
            return context;
        }
    }

    public static int inputMenu() {
        int menu = 0;
        while (true) {
            try {
                menu = inputNum();
                if (!(menu % 1 == 0 && menu > 0 && menu < 8)) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("エラーメッセージ内容：1以上7以下の整数を入力してください: ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return menu;
    }

    public static int inputEmpId() {
        int emp_id = 0;
        while (true) {
            try {
                emp_id = inputNum();
                if (!(emp_id % 1 == 0 && emp_id > 0 && emp_id < 9999)) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("エラーメッセージ内容：1以上9999以下の整数を入力してください: ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return emp_id;
    }

    public static String inputEmpName() {
        String emp_name = null;
        while (true) {
            try {
                emp_name = inputString();
                if (!(emp_name.length() > 0 && emp_name.length() < 31)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("エラーメッセージ内容：1文字以上30文字以下の文字列を入力してください: ");
            }
        }
        return emp_name;

    }

    public static int inputGender() {
        int gender = 0;
        while (true) {
            try {
                gender = inputNum();
                if (!(gender % 1 == 0 && gender > 0 && gender < 3)) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("エラーメッセージ内容：1以上2以下の整数を入力してください: ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return gender;
    }

    public static Date inputBirthdayNotNull() {
        Date birthday = null;
        while (true) {
            String dateContext;
            try {
                dateContext = Input.inputString();
                if (dateContext != null) {
                    java.util.Date formattedDate = sdf.parse(dateContext);
                    birthday = new Date(formattedDate.getTime());
                } else {
                    throw new ParseException(dateContext, 0);
                }
                break;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                System.out.print("エラーメッセージ内容：正しい形式(西暦年/月/日)で日付を入力してください: ");
            }
        }
        return birthday;
    }

    public static Date inputBirthdayCanNull() {
        Date birthday = null;
        while (true) {
            String dateContext;
            try {
                dateContext = Input.inputString();
                if (dateContext != null) {
                    java.util.Date formattedDate = sdf.parse(dateContext);
                    birthday = new Date(formattedDate.getTime());
                } else {
                    return null;
                }
                break;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                System.out.print("エラーメッセージ内容：正しい形式(西暦年/月/日)で日付を入力してください: ");
            }
        }
        return birthday;
    }

    public static int inputDeptId() {
        int dept_id = 0;
        while (true) {
            try {
                dept_id = inputNum();
                if (!(dept_id % 1 == 0 && dept_id > 0 && dept_id < 4)) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("エラーメッセージ内容：1以上3以下の整数を入力してください: ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dept_id;
    }
}
