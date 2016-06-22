package br.com.alura.fvm;

import android.widget.EditText;

import br.com.alura.fvm.modelo.Produto;

/**
 * Created by kleber silva on 21/06/2016.
 */
public class FormularioHelper {


    private final EditText campoNome;
    private final EditText campoValor;

    public FormularioHelper(FormularioActivity activity){
         campoNome=(EditText)activity.findViewById(R.id.fomulario_nome);
         campoValor=(EditText)activity.findViewById(R.id.formulario_valor);
    }

    public Produto pegaProduto() {
        Produto produto= new Produto();
        produto.setNome(campoNome.getText().toString());
        produto.setValor(campoValor.getText().toString());
        return produto;
    }
}
