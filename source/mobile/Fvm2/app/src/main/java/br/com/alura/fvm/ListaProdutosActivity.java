package br.com.alura.fvm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.alura.fvm.modelo.Produto;
import br.com.alura.fvm.modelo.dao.ProdutoDao;

public class ListaProdutosActivity extends AppCompatActivity {

    private ListView listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos_activity);

       listaProdutos=(ListView) findViewById(R.id.lista_produtos);


        Button novoAluno = (Button) findViewById(R.id.novo_produto);
        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentvaiProFormulario=new Intent(ListaProdutosActivity.this, FormularioActivity.class);
                startActivity(intentvaiProFormulario);

    }
});
        registerForContextMenu(listaProdutos);
    }

    private void carregaLista() {
        ProdutoDao dao = new ProdutoDao(this);
        List<Produto> produtos = dao.buscaPrudutos();
        dao.close();


        ArrayAdapter<Produto> adapter= new ArrayAdapter<Produto> (this, android.R.layout.simple_list_item_1, produtos);
        listaProdutos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
               super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
         MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo)menuInfo;
                Produto produto = (Produto)listaProdutos.getItemAtPosition(info.position);

                ProdutoDao dao=new ProdutoDao(ListaProdutosActivity.this);
                dao.deleta(produto);
                dao.close();
                carregaLista();
                Toast.makeText(ListaProdutosActivity.this,"Deletar o Produto"+ produto.getNome(), Toast.LENGTH_SHORT).show();


                return false;
            }
        });
    }

}
