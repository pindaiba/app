package funcionalidades.comanda.model;

import java.math.BigDecimal;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 28/09/15.
 */
@Table(nome="EstabelecimentoItemMenu")
public class EstabelecimentoItemMenu extends Entidade {

    @Column(nome="idEstabelecimento", mapeamentoAtributo = "estabelecimento._id")
    private Estabelecimento estabelecimento;

    @Column(nome="idItemMenuPadrao", mapeamentoAtributo = "itemMenuPadrao._id")
    private ItemMenuPadrao itemMenuPadrao;

    @Column(nome="valorItem")
    private BigDecimal valorItem;


    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public ItemMenuPadrao getItemMenuPadrao() {
        return itemMenuPadrao;
    }

    public void setItemMenuPadrao(ItemMenuPadrao itemMenuPadrao) {
        this.itemMenuPadrao = itemMenuPadrao;
    }

    public BigDecimal getValorItem() {
        return valorItem;
    }

    public void setValorItem(BigDecimal valorItem) {
        this.valorItem = valorItem;
    }
}
