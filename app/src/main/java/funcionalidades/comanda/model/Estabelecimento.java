package funcionalidades.comanda.model;

import java.math.BigDecimal;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.model.Entidade;

/**
 * Created by theo on 22/09/15.
 */
@Table(nome = "Estabelecimento")
public class Estabelecimento extends Entidade {

    @Column(nome="nomeFantasia")
    private String nomeFantasia;

    @Column(nome="endereco")
    private String endereco;

    @Column(nome="idImgLogo")
    private String idImgLogo;

    @Column(nome="posicaoGPS")
    private BigDecimal posicaoGPS;

    @Column(nome="idTipoEstabelecimento", mapeamentoAtributo = "tipoEstabelecimento._id")
    private TipoEstabelecimento tipoEstabelecimento;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getIdImgLogo() {
        return idImgLogo;
    }

    public void setIdImgLogo(String idImgLogo) {
        this.idImgLogo = idImgLogo;
    }

    public BigDecimal getPosicaoGPS() {
        return posicaoGPS;
    }

    public void setPosicaoGPS(BigDecimal posicaoGPS) {
        this.posicaoGPS = posicaoGPS;
    }

    public TipoEstabelecimento getTipoEstabelecimento() {
        return tipoEstabelecimento;
    }

    public void setTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
        this.tipoEstabelecimento = tipoEstabelecimento;
    }
}
