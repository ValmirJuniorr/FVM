package br.com.fvm.model.DAO;

import android.database.sqlite.SQLiteDatabase;

/**SQLiteDatabase
 * Created by valmir on 25/05/16.
 */
public class ProductDao {
    private static ProductDao ourInstance = new ProductDao();
    private SQLiteDatabase db;

    public static ProductDao getInstance() {
        return ourInstance;
    }

    private ProductDao() {

    }
}
