package infra.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by theo on 14/09/15.
 */
public class DataBaseOpenHelper   extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "PINDAIBA_DB";
    private static int VERSAO = 1;

    private static String[] listaComandoCriacaoDataBase = {

            "CREATE TABLE TipoItemMenu (" +
                    "_id INTEGER PRIMARY KEY, " +
                    "nome                TEXT, " +
                    "descricao           TEXT); ",

            "CREATE TABLE TipoUnidadeMedida (" +
                    "_id INTEGER PRIMARY KEY, " +
                    "nome                TEXT, " +
                    "descricao           TEXT); ",

            "CREATE TABLE TipoEstabelecimento (" +
                    "_id INTEGER PRIMARY KEY, " +
                    "nome                TEXT, " +
                    "descricao           TEXT); ",
//
//            "CREATE TABLE ItemMenuPadrao (" +
//                    "_id INTEGER PRIMARY KEY, " +
//                    "nome                TEXT, " +
//                    "descricao           TEXT, " +
//                    "quantidade          INTEGER, " +
//                    "unidade             INTEGER, " +
//                    "idImagem            TEXT, " +
//                    "idTipoItemMenu      INTEGER, "+
//                    "FOREIGN KEY (idTipoItemMenu) " +
//                        "REFERENCES TipoItemMenu(_Id));",
//
//            "CREATE TABLE ItemComanda (" +
//                    "_id INTEGER PRIMARY KEY, " +
//                    "descricao           TEXT, " +
//                    "valorUnitario       REAL, " +
//                    "quantidade          INTEGER, " +
//                    "idItemMenuPadrao    INTEGER, " +
//                    "idComanda           INTEGER, " +
//                    "FOREIGN KEY (idItemMenuPadrao) " +
//                        "REFERENCES ItemMenuPadrao(_Id), "+
//                    "FOREIGN KEY (idComanda) " +
//                        "REFERENCES Comanda(_Id));",

            "CREATE TABLE Grupo (" +
                    "_id INTEGER PRIMARY KEY, "  +
                    "nome                TEXT, " +
                    "descricao           TEXT); ",

//            "CREATE TABLE Usuario (" +
//                    "_id INTEGER PRIMARY KEY, "  +
//                    "nome                TEXT, " +
//                    "idFacebook          TEXT, " +
//                    "idGoogle            TEXT, " +
//                    "idParser            TEXT); ",
//
//            "CREATE TABLE GrupoUsuario (" +
//                    "_id INTEGER PRIMARY KEY, " +
//                    "idGrupo             INTEGER," +
//                    "idUsuario           INTEGER," +
//                    "FOREIGN KEY (idGrupo) " +
//                        "REFERENCES Grupo(_Id), "+
//                    "FOREIGN KEY (idUsuario) " +
//                        "REFERENCES Usuario(_Id));",
//
//            "CREATE TABLE UsuarioItemComanda (" +
//                    "_id INTEGER PRIMARY KEY, " +
//                    "idUsuario           INTEGER," +
//                    "idItemComanda       INTEGER," +
//                    "FOREIGN KEY (idUsuario) " +
//                        "REFERENCES Usuario(_Id), "+
//                    "FOREIGN KEY (idItemComanda) " +
//                        "REFERENCES ItemComanda(_Id));",
//

//            "CREATE TABLE Estabelecimento (" +
//                    "_id INTEGER PRIMARY KEY, " +
//                    "nomeFantasia        TEXT, " +
//                    "descricao           TEXT, " +
//                    "endereco            TEXT, " +
//                    "idImagemLogo        TEXT, " +
//                    "posicaoGPS          REAL, " +
//                    "idTipoEstabelecimento INTEGER, " +
//                    "FOREIGN KEY (idTipoEstabelecimento) " +
//                        "REFERENCES TipoEstabelecimento(_Id));",
////
//            "CREATE TABLE EstabelecimentoItemMenu (" +
//                    "_id INTEGER PRIMARY KEY, " +
//                    "idEstabelecimento   INTEGER, " +
//                    "idItemMenuPadrao    INTEGER, " +
//                    "valorItem           REAL, " +
//                    "FOREIGN KEY (idEstabelecimento) " +
//                        "REFERENCES Estabelecimento(_Id), "+
//                    "FOREIGN KEY (idItemMenuPadrao) " +
//                        "REFERENCES ItemMenuPadrao(_Id));",
//
//            "CREATE TABLE Comanda     (" +
//                    "_id INTEGER PRIMARY KEY, " +
//                    "nome                TEXT, " +
//                    "data                LONG, " +
//                    "idGrupoUsuario      INTEGER, " +
//                    "idEstabelecimento   INTEGER, " +
//                    "FOREIGN KEY (idGrupoUsuario) " +
//                    "REFERENCES GrupoUsuario(_Id), "+
//                    "FOREIGN KEY (idEstabelecimento), " +
//                    "REFERENCES Estabelecimento(_Id)); " ,
//

//            "CREATE TABLE Cobranca    (_id INTEGER PRIMARY KEY, tipoCobranca INTEGER, descricao TEXT, valor REAL, nomeDevedor TEXT, contato INTEGER);"
    };



    public DataBaseOpenHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarEstruturaBanco(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

    /*
     * Executa os comandos de criacao das tabelas e elementos do banco de dados
     */
    private void criarEstruturaBanco(SQLiteDatabase db){
        for (String string : this.listaComandoCriacaoDataBase) {
            db.execSQL(string);
        }
    }

}
