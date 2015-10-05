package funcionalidades.comanda.model;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 17/09/15.
 */
@Table(nome="ItemMenuPadrao")
public class ItemMenuPadrao extends Entidade{

    @Column(nome="nome")
    private String            nome;

    @Column(nome="descricao")
    private String            descricao;

    @Column(nome="quantidade")
    private Integer           quantidade;

    @Column(nome="idImagem")
    private String            idImagem;

    @Column(nome="unidade", mapeamentoAtributo = "unidade.id")
    private TipoUnidadeMedida unidade;

    @Column(nome="idTipoItemMenu", mapeamentoAtributo = "tipoItemMenu._id")
    private TipoItemMenu tipoItemMenu;


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

    public TipoItemMenu getTipoItemMenu() {
        return tipoItemMenu;
    }

    public void setTipoItemMenu(TipoItemMenu tipoItemMenu) {
        this.tipoItemMenu = tipoItemMenu;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public TipoUnidadeMedida getUnidade() {
        return unidade;
    }

    public void setUnidade(TipoUnidadeMedida unidade) {
        this.unidade = unidade;
    }

    public String getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(String idImagem) {
        this.idImagem = idImagem;
    }
}

