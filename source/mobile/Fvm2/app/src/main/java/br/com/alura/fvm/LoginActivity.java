package br.com.alura.fvm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private String nome;
    private String minhaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText login= (EditText) findViewById(R.id.id_login);
        EditText senha= (EditText) findViewById(R.id.id_senha);



        nome= login.getText().toString();
        minhaSenha= senha.getText().toString();
        Button botao= (Button) findViewById(R.id.botao_login);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(LoginActivity.this, "clikei", Toast.LENGTH_LONG).show();
               if ((nome.equals("kleber")&& minhaSenha.equals("123"))) {
                    Toast.makeText(LoginActivity.this,"indo pra lista", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, ListaProdutosActivity.class);
                    startActivity(intent);
               }else{
                   Toast.makeText(LoginActivity.this,"Não entrou", Toast.LENGTH_LONG).show();
               }
            }
        });

    }

}
