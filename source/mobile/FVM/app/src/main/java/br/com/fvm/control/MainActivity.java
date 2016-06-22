package br.com.fvm.control;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import br.com.fvm.R;
import br.com.fvm.model.DAO.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    TextView textResult;
    String opa="";

    private DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        helper = new DataBaseHelper(this);
//        SQLiteDatabase db = helper. getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values. put("name","Chefe é che né pai");
//        values. put("description","BOM demais");
//        values. put("price",1.2);
//        long resultado = db. insert("products", null, values);
//
//        TextView text= (TextView) findViewById(R.id.textView);
//        text.setText("retorno: "+resultado);

    }

    public void goToLogin(View view){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

}
