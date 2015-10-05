package infra.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import funcionalidades.comanda.model.Comanda;
import funcionalidades.comanda.model.Grupo;
import infra.database.DataBaseOpenHelper;
import infra.exception.DBException;
import infra.exception.SystemException;
import infra.model.Entidade;
import infra.util.UtilFunctionsReflection;

import static infra.util.UtilFunctionsReflection.getTableAnnotation;

/**
 * Created by theo on 15/09/15.
 */
public class ManagerDAO {
    private DataBaseOpenHelper dataBaseHelper;
    private SQLiteDatabase dataBase;

    public ManagerDAO(Context contexto){
        dataBaseHelper = new DataBaseOpenHelper(contexto);
        dataBase = dataBaseHelper.getWritableDatabase();
    }

    protected DataBaseOpenHelper getDataBaseHelper() {
        return dataBaseHelper;
    }

    protected void setDataBaseHelper(DataBaseOpenHelper dataBaseHelper) {
        this.dataBaseHelper = dataBaseHelper;
    }

    protected SQLiteDatabase getDataBase() {
        return dataBase;
    }

    protected void setDataBase(SQLiteDatabase dataBase) {
        this.dataBase = dataBase;
    }

    public final int inserir(Entidade entidade) throws DBException, SystemException{

        String nomeTabela = getTableAnnotation(entidade);

        ContentValues values = new ContentValues();

        UtilFunctionsReflection.setarValues(values, entidade);

        long result = getDataBase().insert(nomeTabela, null, values);


        if (result == -1) {
            throw new DBException("Erro ao inserir " + nomeTabela);
        }

        return getId(entidade);
    }

    public final void atualizar(Entidade entidade) throws DBException, SystemException{
        String filtro = "_id=" + entidade.get_id();
        String nomeTabela = entidade.getClass().getName();

        ContentValues values = new ContentValues();

        UtilFunctionsReflection.setarValues(values, entidade);

        long result = getDataBase().update(nomeTabela, values, filtro, null);

        if (result == -1) {
            throw new DBException("Erro ao Atualizar a tabela " + nomeTabela);
        }
    }

    public final void excluir(Entidade entidade) throws SystemException{
        String sqlExcluirHistorico = "DELETE FROM " + getTableAnnotation(entidade) +
                "WHERE _id = " + entidade.get_id();
        getDataBase().execSQL(sqlExcluirHistorico);
    }

    private int getId(Entidade entidade) throws SystemException {
        String sqlListar = "SELECT MAX(_id) _idMax FROM " + UtilFunctionsReflection.getTableAnnotation(entidade);
        int _idMax = 0;

        Cursor cursor = getDataBase().rawQuery(sqlListar, null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0) {
            _idMax = cursor.getInt(0);
        }

        return _idMax;
    }

    public boolean isPersistido(Entidade entidade) throws SystemException {

        if(entidade.get_id() == null
                || entidade.get_id() == 0){
            return false;
        }

        String sqlListar = "SELECT _id FROM " + UtilFunctionsReflection.getTableAnnotation(entidade) + " WHERE _id = " + entidade.get_id();

        Cursor cursor = getDataBase().rawQuery(sqlListar, null);

        if(cursor.getCount() > 0) {
            return true;
        }

        return false;
    }

    public ArrayList listar(Class clazz) throws SystemException, ClassNotFoundException {

        String sqlListar = "SELECT * FROM " + UtilFunctionsReflection.getTableAnnotation(clazz);

        ArrayList lista = new ArrayList();

        Cursor cursor = getDataBase().rawQuery(sqlListar, null);
        cursor.moveToFirst();



        for (int i = 0; i < cursor.getCount(); i++) {
            Object obj = Class.forName(clazz.getName()) ;


//            grupo.set_id(cursor.getInt(0));
//            grupo.setNome(cursor.getString(1));
//            grupo.setDescricao(cursor.getString(2));

            lista.add(obj);
            cursor.moveToNext();
        }

        return lista;
    }

}
