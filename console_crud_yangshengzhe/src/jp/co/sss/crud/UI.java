package jp.co.sss.crud;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class UI {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public static int menu() {
        int menuNum = 0;
        System.out.println("=== 社員管理システム ===");
        System.out.println("1. 全件表示\n2. 社員名検索\n3. 部署ID検索\n4. 登録\n5. 更新\n6. 削除\n7. 終了");
        System.out.print("メニュー番号を入力してください: ");
        menuNum = Input.inputMenu();
        return menuNum;
    }

    public static void selectAll(ResultSet resultSet) {
        System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("emp_id") + "\t");
                System.out.print(resultSet.getString("emp_name") + "\t");
                System.out.print(resultSet.getString("gender").equals("1") ? "男性" : "女性");
                System.out.print("\t" + sdf.format(resultSet.getDate("birthday")) + "\t");
                System.out.println(resultSet.getString("dept_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static String getEmpName() {
        String emp_name = null;
        System.out.print("社員名を入力してください: ");
        emp_name = Input.inputEmpName();
        return emp_name;
    }

    public static void selectByEmpName(ResultSet resultSet) {
        System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("emp_id") + "\t");
                System.out.print(resultSet.getString("emp_name") + "\t");
                System.out.print(resultSet.getString("gender").equals("1") ? "男性" : "女性");
                System.out.print("\t" + sdf.format(resultSet.getDate("birthday")) + "\t");
                System.out.println(resultSet.getString("dept_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static int getDeptId() {
        int dept_id = 0;
        System.out.print("部署ID（1：営業部、2：経理部、3：総務部）を入力してください: ");
        dept_id = Input.inputDeptId();
        return dept_id;
    }

    public static void selectByDeptId(ResultSet resultSet) {
        System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("emp_id") + "\t");
                System.out.print(resultSet.getString("emp_name") + "\t");
                System.out.print(resultSet.getString("gender").equals("1") ? "男性" : "女性");
                System.out.print("\t" + sdf.format(resultSet.getDate("birthday")) + "\t");
                System.out.println(resultSet.getString("dept_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static Employee insert() {
        String emp_name = null;
        int gender = 0;
        Date birthday = null;
        int dept_id = 0;
        // 登録する値を入力
        System.out.print("社員名: ");
        emp_name = Input.inputEmpName();
        System.out.print("性別（1: 男性, 2: 女性）: ");
        gender = Input.inputGender();
        System.out.print("生年月日（西暦年/月/日）: ");
        birthday = Input.inputBirthdayNotNull();
        System.out.print("部署ID（1：営業部、2：経理部、3：総務部）: ");
        dept_id = Input.inputDeptId();
        Employee emp = new Employee(emp_name, gender, birthday, dept_id);
        return emp;
    }

    public static Employee update() throws ParseException, IOException {
        int emp_id = 0;
        String emp_name = null;
        int gender = 0;
        Date birthday = null;
        int dept_id = 0;
        System.out.print("更新する社員の社員IDを入力してください: ");
        emp_id = Input.inputEmpId();
        // 登録する値を入力
        System.out.print("社員名: ");
        emp_name = Input.inputEmpName();
        System.out.print("性別（1: 男性, 2: 女性）: ");
        gender = Input.inputGender();
        System.out.print("生年月日（西暦年/月/日）: ");
        birthday = Input.inputBirthdayCanNull();
        System.out.print("部署ID（1：営業部、2：経理部、3：総務部）: ");
        dept_id = Input.inputDeptId();
        Employee emp = new Employee(emp_id, emp_name, gender, birthday, dept_id);
        return emp;
    }

    public static int delete() {
        int emp_id = 0;
        System.out.print("削除する社員の社員IDを入力してください: ");
        emp_id = Input.inputEmpId();
        return emp_id;
    }

    public static void close() {
        System.out.println("システムを終了します");
    }
}
