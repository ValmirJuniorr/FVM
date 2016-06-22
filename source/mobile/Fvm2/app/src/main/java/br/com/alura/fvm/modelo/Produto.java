package br.com.alura.fvm.modelo;

/**
 * Created by kleber silva on 22/06/2016.
 */
public class Produto {
    private long id;
    private String nome;
    private String valor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return getId()+ "-" + getNome();
    }
}
