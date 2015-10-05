package funcionalidades.comanda.model;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 28/09/15.
 */
@Table(nome = "UsuarioItemComanda")
public class UsuarioItemComanda extends Entidade {

    private Integer idUsuario;
    private Integer idItemComanda;

    public Integer getIdItemComanda() {
        return idItemComanda;
    }

    public void setIdItemComanda(Integer idItemComanda) {
        this.idItemComanda = idItemComanda;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    //    @Column(nome="idUsuario", mapeamentoAtributo = "usuario._id")
//    private Usuario usuario;
//
//    @Column(nome="idItemComanda", mapeamentoAtributo = "itemComanda._id")
//    private ItemComanda itemComanda;
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    public ItemComanda getItemComanda() {
//        return itemComanda;
//    }
//
//    public void setItemComanda(ItemComanda itemComanda) {
//        this.itemComanda = itemComanda;
//    }
}
