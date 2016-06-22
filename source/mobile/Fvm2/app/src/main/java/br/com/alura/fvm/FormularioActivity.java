package br.com.alura.fvm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alura.fvm.modelo.Produto;
import br.com.alura.fvm.modelo.dao.ProdutoDao;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper=new FormularioHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_fomulario,menu);

        return  super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {
           case R.id.menu_formulario_ok:

               Produto produto= helper.pegaProduto();
               ProdutoDao dao=new ProdutoDao(this);
               dao.insere(produto);
               dao.close();

               Toast.makeText(FormularioActivity.this, "Produto " + produto.getNome() + " Salvo com Sucesso", Toast.LENGTH_SHORT).show();


               finish();
               break;
       }
        return super.onOptionsItemSelected(item);
    }
}
