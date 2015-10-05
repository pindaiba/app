package funcionalidades.comanda.model;

import java.util.ArrayList;
import java.util.Date;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 14/09/15.
 */
@Table(nome="Comanda")
public class Comanda extends Entidade {


    @Column(nome="nome")
    private String nome;

    @Column(nome="data")
    private Date data;

    @Column(nome="idEstabelecimento" , mapeamentoAtributo = "estabelecimento._id")
    private Estabelecimento estabelecimento;

    private Grupo grupo;

    private ArrayList<ItemComanda> itensComanda;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public ArrayList<ItemComanda> getItensComanda() {
        return itensComanda;
    }

    public void setItensComanda(ArrayList<ItemComanda> itensComanda) {
        this.itensComanda = itensComanda;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
