package infra.model;

import java.io.Serializable;

import infra.annotation.Column;
import infra.annotation.Table;

/**
 * Created by theo on 14/09/15.
 */
@Table(nome = "Entidade")
public class Entidade implements Serializable{

    private static final long serialVersionUID = -934212741965322372L;

    @Column(nome="_id")
    private Integer _id;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }
}
