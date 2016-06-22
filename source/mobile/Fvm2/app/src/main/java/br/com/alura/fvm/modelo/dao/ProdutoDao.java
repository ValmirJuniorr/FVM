package br.com.alura.fvm.modelo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.fvm.modelo.Produto;

/**
 * Created by kleber silva on 22/06/2016.
 */
public class ProdutoDao extends SQLiteOpenHelper{


    public ProdutoDao(Context context) {
        super(context, "Fvm",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE Produtos(id INTEGER PRIMARY KEY, nome TEXT NOT NULL, valor TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS Produtos";
        db.execSQL(sql);
        onCreate(db);

    }

    public void insere(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados= new ContentValues();
        dados.put("nome", produto.getNome());
        dados.put("valor", produto.getValor());

        db.insert("Produtos", null, dados);
    }

    public List<Produto> buscaPrudutos() {
        String sql= "SELECT * FROM Produtos;";
        SQLiteDatabase db=getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Produto> produtos = new ArrayList<Produto>();
         while(c.moveToNext()){
            Produto produto =new Produto();
            produto.setId(c.getLong(c.getColumnIndex("id")));
            produto.setNome(c.getString(c.getColumnIndex("nome")));
            produto.setValor(c.getString(c.getColumnIndex("valor")));

             produtos.add(produto);
        }
        c.close();
        return  produtos;
    }

    public void deleta(Produto produto) {
        SQLiteDatabase db=getWritableDatabase();
        String[] params ={produto.getId()+""};
        db.delete("Produtos","id=?", params);
    }
}
