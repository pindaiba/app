package funcionalidades.comanda.model;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 21/09/15.
 */
@Table(nome="TipoItemMenu")
public class TipoItemMenu extends Entidade{

    @Column(nome="nome")
    private String nome;

    @Column(nome="descricao")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
