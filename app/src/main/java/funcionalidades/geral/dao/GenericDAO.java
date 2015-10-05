package funcionalidades.geral.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import funcionalidades.comanda.model.Estabelecimento;
import funcionalidades.comanda.model.ItemMenuPadrao;
import funcionalidades.comanda.model.TipoEstabelecimento;
import funcionalidades.comanda.model.TipoItemMenu;
import funcionalidades.comanda.model.TipoUnidadeMedida;
import infra.dao.ManagerDAO;
import infra.exception.SystemException;
import infra.model.Entidade;
import infra.util.UtilFunctionsReflection;

import static infra.util.UtilFunctionsReflection.getTableAnnotation;

/**
 * Created by theo on 29/09/15.
 */
public class GenericDAO extends ManagerDAO {

    public GenericDAO(Context context){
        super(context);
    }

    public final void deleteAll(Entidade entidade) throws SystemException{
        String sqlExcluir = "DELETE FROM " + getTableAnnotation(entidade);
        getDataBase().execSQL(sqlExcluir);
        sqlExcluir.length();

    }

    public ArrayList<Estabelecimento> listar(Estabelecimento entidadeIn) throws SystemException{

        String sqlListar     = "SELECT * FROM " + UtilFunctionsReflection.getTableAnnotation(entidadeIn);
        if(entidadeIn.get_id() != null && entidadeIn.get_id() > 0){
            sqlListar += " WHERE _id = " + entidadeIn.get_id();
        }

        ArrayList<Estabelecimento> listaEntidades = new ArrayList<Estabelecimento>();

        Cursor cursor = getDataBase().rawQuery(sqlListar, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            Estabelecimento entidade = new Estabelecimento();


            entidade.set_id(cursor.getInt(0));
            entidade.setNomeFantasia(cursor.getString(1));
            entidade.setEndereco(cursor.getString(2));

//            TipoEstabelecimento tipoEstabelecimento = new  TipoEstabelecimento(cursor.getInt(0))
            entidade.setTipoEstabelecimento(new TipoEstabelecimento());

            listaEntidades.add(entidade);
            cursor.moveToNext();
        }

        return listaEntidades;
    }

    public ArrayList<TipoEstabelecimento> listar(TipoEstabelecimento entidadeIn) throws SystemException{

        String sqlListar     = "SELECT _id, nome, descricao FROM " + UtilFunctionsReflection.getTableAnnotation(entidadeIn);
        if(entidadeIn.get_id() != null && entidadeIn.get_id() > 0){
            sqlListar += " WHERE _id = " + entidadeIn.get_id();
        }

        ArrayList<TipoEstabelecimento> listaEntidades = new ArrayList<TipoEstabelecimento>();

        Cursor cursor = getDataBase().rawQuery(sqlListar, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            TipoEstabelecimento entidade = new TipoEstabelecimento();

            entidade.set_id(cursor.getInt(0));
            entidade.setNome(cursor.getString(1));
            entidade.setDescricao(cursor.getString(2));

            listaEntidades.add(entidade);
            cursor.moveToNext();
        }

        return listaEntidades;
    }

    public ArrayList<TipoUnidadeMedida> listar(TipoUnidadeMedida entidadeIn) throws SystemException{

        String sqlListar     = "SELECT _id, nome, descricao FROM " + UtilFunctionsReflection.getTableAnnotation(entidadeIn);
        if(entidadeIn.get_id() != null && entidadeIn.get_id() > 0){
            sqlListar += " WHERE _id = " + entidadeIn.get_id();
        }

        ArrayList<TipoUnidadeMedida> listaEntidades = new ArrayList<TipoUnidadeMedida>();

        Cursor cursor = getDataBase().rawQuery(sqlListar, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            TipoUnidadeMedida entidade = new TipoUnidadeMedida();

            entidade.set_id(cursor.getInt(0));
            entidade.setNome(cursor.getString(1));
            entidade.setDescricao(cursor.getString(2));

            listaEntidades.add(entidade);
            cursor.moveToNext();
        }

        return listaEntidades;
    }

    public ArrayList<TipoItemMenu> listar(TipoItemMenu entidadeIn) throws SystemException{

        String sqlListar     = "SELECT _id, nome, descricao FROM " + UtilFunctionsReflection.getTableAnnotation(entidadeIn);
        if(entidadeIn.get_id() != null && entidadeIn.get_id() > 0){
            sqlListar += " WHERE _id = " + entidadeIn.get_id();
        }

        ArrayList<TipoItemMenu> listaEntidades = new ArrayList<TipoItemMenu>();

        Cursor cursor = getDataBase().rawQuery(sqlListar, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            TipoItemMenu entidade = new TipoItemMenu();

            entidade.set_id(cursor.getInt(0));
            entidade.setNome(cursor.getString(1));
            entidade.setDescricao(cursor.getString(2));

            listaEntidades.add(entidade);
            cursor.moveToNext();
        }

        return listaEntidades;
    }

    public ArrayList<ItemMenuPadrao> listar(ItemMenuPadrao entidadeIn) throws SystemException{

        String sqlListar     = "SELECT _id, nome, descricao, idImage, quantidade, unidade FROM " + UtilFunctionsReflection.getTableAnnotation(entidadeIn);
        if(entidadeIn.get_id() != null && entidadeIn.get_id() > 0){
            sqlListar += " WHERE _id = " + entidadeIn.get_id();
        }

        ArrayList<ItemMenuPadrao> listaEntidades = new ArrayList<ItemMenuPadrao>();

        Cursor cursor = getDataBase().rawQuery(sqlListar, null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            ItemMenuPadrao entidade = new ItemMenuPadrao();

            entidade.set_id(cursor.getInt(0));
            entidade.setNome(cursor.getString(1));
            entidade.setDescricao(cursor.getString(2));
            entidade.setIdImagem(cursor.getString(3));
            entidade.setQuantidade(cursor.getInt(4));
//            entidade.setUnidade(TipoUnidadeMedida.getById(cursor.getInt(5)));
            listaEntidades.add(entidade);
            cursor.moveToNext();
        }

        return listaEntidades;
    }

    public void carregarCargaInicial(){
        String[] listaComandoCargaInicialBase = {
            "DELETE FROM TipoItemMenu;",
                "DELETE FROM ItemMenuPadrao;",
                "DELETE FROM Grupo;",

                "INSERT INTO TipoItemMenu(_id, nome, descricao) " +
                        "values(1, 'Cerveja', 'Cervejas e afins'); ",
                "INSERT INTO TipoItemMenu(_id, nome, descricao) " +
                        "values(2, 'Drink', 'Drinks..'); ",
                "INSERT INTO TipoItemMenu(_id, nome, descricao) " +
                        "values(3, 'Destilados', 'Whisk, Cachaça, Vodka.'); ",
                "INSERT INTO TipoItemMenu(_id, nome, descricao) " +
                        "values(4, 'Petiscos', ''); ",
                "INSERT INTO TipoItemMenu(_id, nome, descricao) " +
                        "values(5, 'Sandwiche', ''); ",
                "INSERT INTO TipoItemMenu(_id, nome, descricao) " +
                        "values(6, 'Feijoada', ''); ",

                "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
                        "values(1, 'Cerveja Litrão', '', 1, 'litro', 'imgCervejaLitrao', 1);",
                "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
                        "values(2, 'Cerveja Normal', '', 600, 'ml', 'imgCervejaNormal', 1);",
                "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
                        "values(3, 'Cerveja Long neck', '', 235, 'ml', 'imgCervejaLongNeck', 1);",
                "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
                        "values(4, 'Caipirinha de Frutas', '', 200, 'ml', 'imgCaipirinha', 2);",
                "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
                        "values(5, 'Mojito', '', 200, 'ml', 'imgMojito', 2);",

                "INSERT INTO Grupo(nome, descricao) values('Grupo A', Grupo de Teste A);"
        };

        for (String string : listaComandoCargaInicialBase) {
            getDataBase().execSQL(string);
        }
    }
}
