package br.com.fvm.model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.fvm.model.ConstsFVM;

/**
 * Created by Valmir on 25/05/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context, ConstsFVM.DATA_BASE_FVM,null,ConstsFVM.VERSION_DATA_BASE_FVM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(_id INTEGER PRIMARY KEY," +
                " name_user TEXT, email_user TEXT,login_user TEXT, password_user TEXT  );");

        db.execSQL("CREATE TABLE products(_id INTEGER PRIMARY KEY," +
                "name TEXT, description TEXT, price double );");

        db.execSQL("CREATE TABLE items(_id INTEGER PRIMARY KEY," +
                "name TEXT, description TEXT, price double );");

        db.execSQL("CREATE TABLE orders(_id INTEGER," +
                "_id_item INTEGER, PRIMARY KEY(_id_product,_id_item) );");

        db.execSQL("CREATE TABLE items_products(_id INTEGER, " +
                "_id_item INTEGER, PRIMARY KEY(_id_product,_id_item)," +
                "FOREIGN KEY (_id_product )  REFERENCES products (_id)," +
                "FOREIGN KEY (_id_item )  REFERENCES items  (_id));");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
