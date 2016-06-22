package br.com.alura.fvm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Objects;

import br.com.alura.fvm.modelo.User;
import br.com.alura.fvm.util.HTTPUtils;

public class LoginActivity extends AppCompatActivity {
    EditText editLogin,editSenha;

    private String nome,senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editLogin= (EditText) findViewById(R.id.id_login);
        editSenha= (EditText) findViewById(R.id.id_senha);
    }

    public void logar (View view){
        nome= editLogin.getText().toString();
        senha= editSenha.getText().toString();
        new LoginTask().execute(nome,senha);

//        Toast.makeText(LoginActivity.this, "clikei", Toast.LENGTH_LONG).show();
//        if ((nome.equals("kleber")&& senha.equals("123"))) {
//            Toast.makeText(LoginActivity.this,"indo pra lista", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(LoginActivity.this, ListaProdutosActivity.class);
//            startActivity(intent);
//        }else{
//            Toast.makeText(LoginActivity.this,"Não entrou", Toast.LENGTH_LONG).show();
//        }
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

                String url = "http://192.168.43.194:8080/FVM/service/user/login" ;
                Gson gson=new Gson();
                User user=new User();
                user.setLogin(login);
                user.setPassword(password);
                String data=gson.toJson(user);
                String conteudo= HTTPUtils.requestPost(url,data);
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
            Intent intent = new Intent(LoginActivity.this, ListaProdutosActivity.class);
            startActivity(intent);
//            if(result[0].equals("ok")){
//                Intent intent = new Intent(LoginActivity.this, ListaProdutosActivity.class);
//                startActivity(intent);
//
//            }else{
//                Dialog alert=new Dialog(LoginActivity.this);
//                alert.setTitle("Erro no Login");
//
//            }

            dialog.dismiss();


        }
    }


}
