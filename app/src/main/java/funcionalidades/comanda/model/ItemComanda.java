package funcionalidades.comanda.model;

import java.math.BigDecimal;
import java.util.ArrayList;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 14/09/15.
 */
@Table(nome="ItemComanda")
public class ItemComanda extends Entidade {

    @Column(nome="descricao")
    private String              descricao;

    @Column(nome="valorUnitario")
    private BigDecimal          valorUnitario;

    @Column(nome="quantidade")
    private Integer             quantidade;

    @Column(nome="itemMenuPadrao")
    private ItemMenuPadrao      itemMenuPadrao;

    @Column(nome="idComanda", mapeamentoAtributo = "comanda._id")
    private Comanda             comanda;

    private ArrayList<Usuario>  usuarios;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    public ItemMenuPadrao getItemMenuPadrao() {
        return itemMenuPadrao;
    }

    public void setItemMenuPadrao(ItemMenuPadrao itemMenuPadrao) {
        this.itemMenuPadrao = itemMenuPadrao;
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
