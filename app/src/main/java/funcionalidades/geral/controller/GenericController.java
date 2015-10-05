package funcionalidades.geral.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import funcionalidades.comanda.model.Estabelecimento;
import funcionalidades.comanda.model.ItemMenuPadrao;
import funcionalidades.comanda.model.TipoEstabelecimento;
import funcionalidades.comanda.model.TipoItemMenu;
import funcionalidades.comanda.model.TipoUnidadeMedida;
import funcionalidades.geral.dao.GenericDAO;
import infra.controller.ManagerController;
import infra.exception.DBException;
import infra.exception.SystemException;
import infra.util.UtilFunctionsCargaInicial;

/**
 * Created by theo on 30/09/15.
 */
public class GenericController extends ManagerController<GenericDAO> {

    public GenericController(Context contexto){
        super(contexto, new GenericDAO(contexto));
    }

    public List<TipoEstabelecimento> listarTipoEstabelecimentoById(Integer _id) throws SystemException {
        TipoEstabelecimento entidade = new TipoEstabelecimento();
        entidade.set_id((_id != null && _id != 0) ? _id : null);
        return getDao().listar(entidade);
    }

    public List<Estabelecimento> listarEstabelecimentoById(Integer _id) throws SystemException {
        Estabelecimento entidade = new Estabelecimento();
        entidade.set_id((_id != null && _id != 0) ? _id : null);
        return getDao().listar(entidade);
    }

    public List<TipoItemMenu> listarTipoItemMenuById(Integer _id) throws SystemException {
        TipoItemMenu entidade = new TipoItemMenu();
        entidade.set_id((_id != null && _id != 0) ? _id : null);
        return getDao().listar(entidade);
    }

    public List<ItemMenuPadrao> listarItemMenuPadraoById(Integer _id) throws SystemException {
        ItemMenuPadrao entidade = new ItemMenuPadrao();
        entidade.set_id((_id != null && _id != 0) ? _id : null);
        return getDao().listar(entidade);
    }

    public List<TipoUnidadeMedida> listarTipoUnidadeMedidaById(Integer _id) throws SystemException {
        TipoUnidadeMedida entidade = new TipoUnidadeMedida();
        entidade.set_id((_id != null && _id != 0) ? _id : null);
        return getDao().listar(entidade);
    }

    public void carregarEntidadeDominio() throws DBException, SystemException {

        //TIPO ITEM MENU
        getDao().deleteAll(new TipoItemMenu());
        for(TipoItemMenu item: UtilFunctionsCargaInicial.getCargaTipoItemMenu()){
            getDao().inserir(item);
        }

        // TIPO UNIDADE
        getDao().deleteAll(new TipoUnidadeMedida());
        for(TipoUnidadeMedida item: UtilFunctionsCargaInicial.getCargaTipoUnidadeMedida()){
            getDao().inserir(item);
        }

        // TIPO ESTABELECIMENTO
        getDao().deleteAll(new TipoEstabelecimento());
        for(TipoEstabelecimento item: UtilFunctionsCargaInicial.getCargaTipoEstabelecimento()){
            getDao().inserir(item);
        }



    }




}
