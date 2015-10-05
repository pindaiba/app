package funcionalidades.comanda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import funcionalidades.comanda.model.Comanda;
import funcionalidades.comanda.model.Grupo;
import funcionalidades.comanda.model.ItemComanda;
import infra.dao.ManagerDAO;
import infra.exception.DBException;
import infra.exception.SystemException;
import infra.util.UtilFunctions;
import infra.util.UtilFunctionsReflection;

/**
 * Created by theo on 15/09/15.
 */
public class ComandaDAO extends ManagerDAO {

    public ComandaDAO(Context contexto){
        super(contexto);
    }

//    public void inserir(Comanda comanda) throws DBException{
//        ContentValues values = new ContentValues();
//
//        values.put("nome", comanda.getNome());
//        values.put("data", UtilFunctions.dateToLong(comanda.getData()));
//
//        long result = getDataBase().insert("comanda", null, values);
//
//        if (result == -1) {
//            throw new DBException("Erro ao inserir comanda.");
//        }
//    }

//    public void inserir(ItemComanda itemComanda) throws DBException{
//        ContentValues values = new ContentValues();
//
//        values.put("descricao", itemComanda.getDescricao());
//        values.put("quantidade", itemComanda.getQuantidade());
//
//        long result = getDataBase().insert("itemComanda", null, values);
//
//        if (result == -1) {
//            throw new DBException("Erro ao inserir Item da Comanda.");
//        }
//    }

    /**
     * Listar comadas
     * @return lista de comandas
     */
    public List<Comanda> listarComandas(){

        String sqlListarComanda     = "SELECT _id, nome, data FROM Comanda ";

        ArrayList<Comanda> listaComandas = new ArrayList<Comanda>();

        Cursor cursor = getDataBase().rawQuery(sqlListarComanda, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            Comanda comanda = new Comanda();
            comanda.set_id(cursor.getInt(0));
            comanda.setNome(cursor.getString(1));
            comanda.setData(UtilFunctions.longToDate(cursor.getLong(2)));

            listaComandas.add(comanda);
            cursor.moveToNext();
        }

        return listaComandas;
    }

    public ArrayList<Grupo> listarGrupo() throws SystemException{

        String sqlListarComanda     = "SELECT _id, nome, descricao FROM " + UtilFunctionsReflection.getTableAnnotation(new Grupo());

        ArrayList<Grupo> listaObj = new ArrayList<>();

        Cursor cursor = getDataBase().rawQuery(sqlListarComanda, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            Grupo grupo = new Grupo();


            grupo.set_id(cursor.getInt(0));
            grupo.setNome(cursor.getString(1));
            grupo.setDescricao(cursor.getString(2));

            listaObj.add(grupo);
            cursor.moveToNext();
        }

        return listaObj;
    }


}
