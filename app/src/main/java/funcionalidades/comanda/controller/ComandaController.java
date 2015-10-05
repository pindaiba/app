package funcionalidades.comanda.controller;

import android.content.Context;
import android.util.Log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.pindaiba.pindaiba.R;
import funcionalidades.comanda.dao.ComandaDAO;
import funcionalidades.comanda.model.Comanda;
import funcionalidades.comanda.model.Grupo;
import funcionalidades.comanda.model.ItemComanda;
import funcionalidades.comanda.model.Usuario;
import funcionalidades.comanda.model.UsuarioItemComanda;
import funcionalidades.geral.dao.GenericDAO;
import infra.controller.ManagerController;
import infra.dao.ManagerDAO;
import infra.exception.BusinessException;
import infra.exception.DBException;
import infra.exception.SystemException;

/**
 * Created by theo on 15/09/15.
 */
public class ComandaController extends ManagerController <ComandaDAO>{

    public ComandaController(Context context){
        super(context, new ComandaDAO(context));
    }



    public Grupo criarComandaIndividual(Comanda comanda, Usuario usuario) throws BusinessException, DBException , SystemException{

        // Persistindo Comanda
        if(comanda.getNome() == null || comanda.getNome().equals("")){
            throw new BusinessException("Informe um nome para comanda.");
        }
        comanda.setData(new Date());
        comanda.set_id(getDao().inserir(comanda));

        // Persistindo Grupo
        Grupo grupo = new Grupo();
        grupo.setNome("Comanda Individual");
        grupo.setDescricao("Grupo criado automaticamente.");
        grupo.set_id(getDao().inserir(grupo));
        grupo.setComanda(comanda);

        boolean existeUsuario = (usuario.get_id()!= null && usuario.get_id()!=0)?
                getDao().isPersistido(usuario):false;

        if(!existeUsuario){
            usuario.set_id(getDao().inserir(usuario));
        }
        grupo.getUsuarios().add(usuario);

        return grupo;
    }

    public ItemComanda inserirItemComanda(ItemComanda itemComanda) throws SystemException, DBException, BusinessException {

        if(itemComanda.getItemMenuPadrao() == null){
            throw new BusinessException(getContext().getString(R.string.msnErroInclusao));
        }

        boolean existeItemComanda = (itemComanda.get_id()!= null && itemComanda.get_id()!=0)?
                getDao().isPersistido(itemComanda):false;

        if(!existeItemComanda){
            itemComanda.set_id(getDao().inserir(itemComanda));
        }

        return itemComanda;
    }

    public ItemComanda atualizarItemComanda(ItemComanda itemComanda) throws SystemException, DBException, BusinessException {

        // Validacao de entrada
        if(itemComanda.getItemMenuPadrao() == null){
            throw new BusinessException(getContext().getString(R.string.msnErroInclusao));
        }

        if(itemComanda.getUsuarios() != null
                && itemComanda.getUsuarios().size() != 1){
            throw new BusinessException(getContext().getString(R.string.msnErroInclusao));
        }

        if(itemComanda.getValorUnitario() == null
                || itemComanda.getValorUnitario().floatValue() > 0f){
            throw new BusinessException(getContext().getString(R.string.msnErroInclusao));
        }

        boolean existeItemComanda = (itemComanda.get_id()!= null && itemComanda.get_id()!=0)?
                getDao().isPersistido(itemComanda):false;

        if(!existeItemComanda){
            throw new BusinessException(getContext().getString(R.string.msnErroInclusao));
        }

        getDao().atualizar(itemComanda);

//        UsuarioItemComanda usuarioItemComanda = new UsuarioItemComanda();
//        usuarioItemComanda.setItemComanda(itemComanda);
//        usuarioItemComanda.setUsuario(itemComanda.getUsuarios().get(0));

//        getDao().inserir(usuarioItemComanda);

        return itemComanda;
    }

    public void inserirGrupo(Grupo grupo) throws BusinessException, DBException, SystemException{
        int _id = getDao().inserir(grupo);
        Log.i("_ID", Integer.toString(_id));
    }

    public ArrayList<Grupo> listarGrupo() throws SystemException {

//        GenericDAO dao = new GenericDAO(getContext());
        ArrayList<Grupo> lista = getDao().listarGrupo();
        return lista;
    }

//    public void inserirItemComanda(Comanda comanda) throws BusinessException, DBException {
//
//        if (comanda.getListaItensComanda() == null
//                || comanda.getListaItensComanda().size() == 0){
//            throw new BusinessException("Adicione um item na comanda.");
//        }
//
//        if(comanda.get_id() == null
//                || comanda.get_id().intValue() == 0){
//            inserirComanda(comanda);
//        }
//
//        for (ItemComanda itemComanda: comanda.getListaItensComanda()){
//            getDao().inserir(itemComanda);
//        }
//    }
//
//    public BigDecimal getTotalComanda(Comanda comanda){
//
//        float total = 0l;
//
//        for (ItemComanda itemComanda: comanda.getListaItensComanda()){
//            total += itemComanda.getValorUnitario().floatValue();
//        }
//
//        return new BigDecimal(total);
//    }
//
//    public Integer getQuantidadeItens(Comanda comanda){
//        int total = 0;
//
//        for (ItemComanda itemComanda: comanda.getListaItensComanda()){
//            total += itemComanda.getQuantidade().intValue();
//        }
//
//        return total;
//    }

    public void incrementarItem(ItemComanda itemComanda){
    }

    public List<Comanda> listarComandas(){

        return null;
    }

}
