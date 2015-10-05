package funcionalidades.comanda.model;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 28/09/15.
 */
@Table(nome="GrupoUsuario")
public class GrupoUsuario extends Entidade{

    private Integer   idGrupo;
    private Integer idUsuario;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

//    @Column(nome="idGrupo", mapeamentoAtributo = "grupo._id")
//    private Grupo   grupo;
//
//    @Column(nome="idUsuario", mapeamentoAtributo = "usuario._id")
//    private Usuario usuario;
//
//    public Grupo getGrupo() {
//        return grupo;
//    }
//
//    public void setGrupo(Grupo grupo) {
//        this.grupo = grupo;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
}
