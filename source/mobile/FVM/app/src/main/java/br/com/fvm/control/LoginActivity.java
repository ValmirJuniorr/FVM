package br.com.fvm.control;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import br.com.fvm.R;
import br.com.fvm.model.User;
import br.com.fvm.util.HTTPUtils;

public class LoginActivity extends AppCompatActivity {
    EditText editTextLogin, editTextPassword;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextLogin =(EditText) findViewById(R.id.editTextLogin);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
        textView=(TextView) findViewById(R.id.textResult);

    }

    public  void login(View view){
        new LoginTask().execute(editTextLogin.getText().toString(),editTextPassword.getText().toString());
    }

    private class LoginTask extends AsyncTask<String, Void, String[]> {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(LoginActivity.this);
            dialog.show();
        }

        @Override
        protected String[] doInBackground(String... params) {
            try {
                String login,password;
                login=params[0];
                password=params[1];

                String urlLogin = "http://10.30.0.83:8080/FVM/service/user/getOne/12" ;
                String url = Uri.parse(urlLogin).toString();
                //to por aqui;
//                Gson gson=new Gson();
//                User user=new User();
//                user.setLogin(login);
//                user.setPassword(password);
//                String data=gson.toJson(user);
               //String conteudo = HTTPUtils.requestPost(url,data);

                String conteudo=HTTPUtils.doGet(url);
                if(conteudo.equals("Login successful")){
                    return new String[]{"ok"};
                }
                return  new String[]{"opa"};
            } catch (Exception e) {
                return new String[]{e.getMessage()};
            }

        }


        @Override
        protected void onPostExecute(String[] result) {
            textView.setText("o resultado foi: "+result[0]);
            dialog.dismiss();


        }
    }

}
