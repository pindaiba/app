package funcionalidades.comanda.model;

import java.util.ArrayList;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 22/09/15.
 */
@Table(nome="Grupo")
public class Grupo extends Entidade {

    @Column(nome="nome")
    private String nome;

    @Column(nome="descricao")
    private String descricao;

    private Comanda comanda;

    private ArrayList<Usuario> usuarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
}
