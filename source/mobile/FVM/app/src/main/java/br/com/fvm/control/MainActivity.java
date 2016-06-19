package br.com.fvm.control;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.fvm.R;
import br.com.fvm.model.DAO.DataBaseHelper;
import br.com.fvm.util.HTTPUtils;

public class MainActivity extends AppCompatActivity {
    EditText editTextLogin, editTextPassword;
    TextView textResult;
    String opa="";

    private DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextLogin =(EditText) findViewById(R.id.editTextLogin);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
        textResult=(TextView) findViewById(R.id.textViewResult);
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
        new LoginTask().execute("oi","opa");
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
                String urlLogin = "localhost:8080/FVM/service/user/login" ;
                String url = Uri.parse(urlLogin).toString();
                //to por aqui;
                String data="";
                String conteudo = HTTPUtils.requestPost(url,data);
               if(conteudo.equals("Login successful")){
                   return new String[]{"ok"};
               }
                return  new String[]{"opa"};
            } catch (Exception e) {
                return null;
            }

        }


        @Override
        protected void onPostExecute(String[] result) {
            if(result != null){
                textResult.setText(opa);
            }
            dialog.dismiss();
        }
    }

}
