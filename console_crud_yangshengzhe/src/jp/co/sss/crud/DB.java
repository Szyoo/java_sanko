package jp.co.sss.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DB {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private static final String USER_NAME = "console_crud_user";
    private static final String PASSWORD = "systemsss";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        // System.out.println("DBに接続しました");
        return conn;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                // System.out.println("DBと切断しました");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void selectAll(Connection connection) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // SQL文を準備
        String sql = "SELECT e.emp_id,e.emp_name,e.gender,e.birthday,d.dept_name FROM employee e,department d WHERE e.dept_id = d.dept_id";
        try {
            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);
            // SQL文を実行
            resultSet = preparedStatement.executeQuery();
            // レコードを出力
            UI.selectAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // クローズ処理
            DB.close(resultSet);
            DB.close(preparedStatement);
        }
    }

    public static void selectByEmpName(Connection connection) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String emp_name = UI.getEmpName();
        // SQL文を準備
        String sql = "SELECT e.emp_id,e.emp_name,e.gender,e.birthday,d.dept_name FROM employee e,department d WHERE emp_name LIKE ? and e.dept_id = d.dept_id";
        try {
            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);
            // 入力値をバインド
            preparedStatement.setString(1, "%" + emp_name + "%");
            // SQL文を実行
            resultSet = preparedStatement.executeQuery();
            // レコードを出力
            UI.selectByEmpName(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // クローズ処理
            DB.close(resultSet);
            DB.close(preparedStatement);
        }
    }

    public static void selectByDeptId(Connection connection) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int dept_id = UI.getDeptId();
        // SQL文を準備
        String sql = "SELECT e.emp_id,e.emp_name,e.gender,e.birthday,d.dept_name FROM employee e,department d WHERE e.dept_id = ? and e.dept_id = d.dept_id";
        try {
            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);
            // 入力値をバインド
            preparedStatement.setInt(1, dept_id);
            // SQL文を実行
            resultSet = preparedStatement.executeQuery();
            // レコードを出力
            UI.selectByEmpName(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // クローズ処理
            DB.close(resultSet);
            DB.close(preparedStatement);
        }
    }

    public static void insert(Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            Employee emp = UI.insert();
            int nextID_from_seq = getSeq(connection);

            // SQL文を準備
            String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";
            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);
            // 入力値をバインド
            preparedStatement.setInt(1, nextID_from_seq);
            preparedStatement.setString(2, emp.getEmp_name());
            preparedStatement.setInt(3, emp.getGender());
            try {
                preparedStatement.setDate(4, emp.getBirthday());
            } catch (IllegalArgumentException e) {
                System.out.println("エラーメッセージ内容：正しい形式(西暦年/月/日)で日付を入力してください: ");
            }
            preparedStatement.setInt(5, emp.getDept_id());
            // SQL文を実行
            preparedStatement.executeUpdate();
            System.out.println("社員情報を登録しました\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(preparedStatement);
        }
    }

    public static void update(Connection connection) {
        PreparedStatement preparedStatement = null;
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("emp_name", false);
        map.put("gender", false);
        map.put("birthday", false);
        map.put("dept_id", false);
        try {
            Employee emp = UI.update();
            String emp_name = emp.getEmp_name();
            if (emp_name != null) {
                map.put("emp_name", true);
            }
            int gender = emp.getGender();
            if (gender != 0) {
                map.put("gender", true);
            }
            Date birthday = emp.getBirthday();
            if (birthday != null) {
                map.put("birthday", true);
            }
            int dept_id = emp.getDept_id();
            if (dept_id != 0) {
                map.put("dept_id", true);
            }

            // SQL文を準備
            String sql = "UPDATE employee SET ";
            Boolean flag = false;
            if (map.get("emp_name")) {
                sql += "emp_name = ?";
                flag = true;
            }
            if (map.get("gender")) {
                if (flag) {
                    sql += ", ";
                }
                sql += "gender = ?";
                flag = true;
            }
            if (map.get("birthday")) {
                if (flag) {
                    sql += ", ";
                }
                sql += "birthday = ?";
                flag = true;
            }
            if (map.get("dept_id")) {
                if (flag) {
                    sql += ", ";
                }
                sql += "dept_id = ?";
            }
            sql += " WHERE emp_id = ?";
            // System.out.println(sql);
            int count = 1;

            // // SQL文を準備
            // sql += "UPDATE employee SET emp_name = ?, gender = ?, birthday = ?, dept_id =
            // ? WHERE emp_id = ?";
            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);
            // 入力値をバインド
            if (map.get("emp_name")) {
                preparedStatement.setString(count++, emp.getEmp_name());
            }
            if (map.get("gender")) {
                preparedStatement.setInt(count++, emp.getGender());
            }
            if (map.get("birthday")) {
                preparedStatement.setDate(count++, emp.getBirthday());
            }
            if (map.get("dept_id")) {
                preparedStatement.setInt(count++, emp.getDept_id());
            }
            preparedStatement.setInt(count++, emp.getEmp_id());
            // SQL文を実行
            preparedStatement.executeUpdate();
            System.out.println("社員情報を更新しました\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // クローズ処理
            DB.close(preparedStatement);
        }
    }

    public static void delete(Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            int emp_id = UI.delete();
            // SQL文を準備
            String sql = "DELETE FROM employee WHERE emp_id = ?";
            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);
            // 入力値をバインド
            preparedStatement.setInt(1, emp_id);
            // SQL文を実行
            preparedStatement.executeUpdate();
            System.out.println("社員情報を削除しました\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // クローズ処理
            DB.close(preparedStatement);
        }
    }

    public static int getSeq(Connection connection) {
        String sql = "select seq_emp.NEXTVAL from DUAL";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int nextID_from_seq = 0;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                nextID_from_seq = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextID_from_seq;
    }

}
