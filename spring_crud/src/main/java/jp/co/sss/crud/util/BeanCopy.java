package jp.co.sss.crud.util;

import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;

public class BeanCopy {

    /**
     * Formクラスの各フィールドの値をエンティティ(Employee)にコピー
     *
     * @param form
     *             入力された社員情報
     * @return エンティティ
     */
    public static Employee copyFormToEmployee(EmployeeForm form) {
        return null;
        // ここに追記
    }

    /**
     * エンティティ(Employee)の各フィールドの値をFormクラスにコピー
     *
     * @param entity
     *               エンティティ
     * @return Formクラス
     */
    public static EmployeeForm copyEntityToForm(Employee entity, EmployeeForm form) {
        return form;

        // ここに追記
    }
}
