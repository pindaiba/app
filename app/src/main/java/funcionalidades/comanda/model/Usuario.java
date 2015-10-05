package funcionalidades.comanda.model;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 22/09/15.
 */
@Table(nome = "Usuario")
public class Usuario extends Entidade {

    @Column(nome="nome")
    private String nome;

    @Column(nome="idFacebook")
    private String idFacebook;

    @Column(nome="idGoogle")
    private String idGoogle;

    @Column(nome="idParse")
    private String idParse;

    private Grupo grupo;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

    public String getIdGoogle() {
        return idGoogle;
    }

    public void setIdGoogle(String idGoogle) {
        this.idGoogle = idGoogle;
    }

    public String getIdParse() {
        return idParse;
    }

    public void setIdParse(String idParse) {
        this.idParse = idParse;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
