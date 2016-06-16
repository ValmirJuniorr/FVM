package br.com.fvm.control;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import br.com.fvm.R;
import br.com.fvm.model.DAO.DataBaseHelper;
import br.com.fvm.util.HTTPUtils;

public class MainActivity extends AppCompatActivity {
    EditText editTextLogin, editTextPassword;

    private DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextLogin =(EditText) findViewById(R.id.editTextLogin);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
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

    public  void login(View view){

    }


    private class LoginTask extends AsyncTask<String, Void, String[]> {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.show();
        }

        @Override
        protected String[] doInBackground(String... params) {
            try {
                String filtro = params[0];
                if(TextUtils.isEmpty(filtro)){
                    return null;
                }
                String urlLogin = "localhost:8080/FVM/service/user/login" ;
                String url = Uri.parse(urlLogin + filtro).toString();
                String conteudo = HTTPUtils.request(url);
               if(conteudo.equals("Login successful")){
                   return new String[]{"ok"};
               }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        }


        @Override
        protected void onPostExecute(String[] result) {
            if(result != null){

            }
            dialog.dismiss();
        }
    }

}
