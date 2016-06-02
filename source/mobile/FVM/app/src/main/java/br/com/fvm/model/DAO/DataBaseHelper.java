package br.com.fvm.model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.fvm.model.Constants;

/**
 * Created by Valmir on 25/05/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context, Constants.DATA_BASE_FVM,null, Constants.VERSION_DATA_BASE_FVM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users(_id INTEGER PRIMARY KEY," +
                " name_user TEXT, email_user TEXT,login_user TEXT, password_user TEXT  );");

        db.execSQL("CREATE TABLE products(_id INTEGER PRIMARY KEY," +
                "name TEXT, description TEXT, price double );");

        db.execSQL("CREATE TABLE items(_id INTEGER PRIMARY KEY," +
                "name TEXT, description TEXT, price double );");


        db.execSQL("CREATE TABLE orders(_id INTEGER,  PRIMARY KEY," +
                "dateOpen DATE, dateRealized DATE, dateIN_ATTENDANCE DATE," +
                "dateDELIVERED DATE, state TEXT, id_user INTEGER , id_employee INTEGER" +
                "FOREIGN KEY (id_user) REFERENCES users (_id)" +
                "FOREIGN KEY (id_employee) REFERENCES users (_id));");

        db.execSQL("CREATE TABLE itens_products(id_item INTEGER, id_product," +
                " PRIMARY KEY(id_item,id_product), " +
                "FOREIGN KEY (id_item) REFERENCES items (_id) " +
                "FOREIGN KEY (id_product) REFERENCES products (_id));");

        db.execSQL("CREATE TABLE itens_products_additional(id_item INTEGER, id_product," +
                " PRIMARY KEY(id_item,id_product), " +
                "FOREIGN KEY (id_item) REFERENCES items (_id) " +
                "FOREIGN KEY (id_product) REFERENCES products (_id));");

        db.execSQL("CREATE TABLE products_orders(id_order INTEGER, id_product," +
                "PRIMARY KEY(id_order,id_product), " +
                "FOREIGN KEY (id_order) REFERENCES orders (_id) " +
                "FOREIGN KEY (id_product) REFERENCES products (_id));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
