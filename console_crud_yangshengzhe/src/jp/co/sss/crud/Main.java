package jp.co.sss.crud;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // DBに接続
            connection = DB.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // プログラム起動後、メニューの画面を表示する
        int menuNum = UI.menu();
        while (menuNum != 7) {
            switch (menuNum) {
                case 1:
                    // 全件表示
                    DB.selectAll(connection);
                    break;
                case 2:
                    // 社員名検索
                    DB.selectByEmpName(connection);
                    break;
                case 3:
                    // 部署ID検索
                    DB.selectByDeptId(connection);
                    break;
                case 4:
                    // 登録
                    DB.insert(connection);
                    break;
                case 5:
                    // 更新
                    DB.update(connection);
                    break;
                case 6:
                    // 削除
                    DB.delete(connection);
                    break;
            }
            // 処理実行後、再びメニューを表示する
            menuNum = UI.menu();
        }
        // DBの接続を切断
        DB.close(connection);
        // 終了
        UI.close();
    }
}
