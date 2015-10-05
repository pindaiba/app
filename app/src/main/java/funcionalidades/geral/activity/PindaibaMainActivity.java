package funcionalidades.geral.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.pindaiba.pindaiba.R;
import funcionalidades.comanda.controller.ComandaController;
import funcionalidades.comanda.model.Grupo;
import funcionalidades.comanda.model.TipoEstabelecimento;
import funcionalidades.comanda.model.TipoItemMenu;
import funcionalidades.comanda.model.TipoUnidadeMedida;
import funcionalidades.comanda.viewadapter.GrupoViewAdapter;
import funcionalidades.geral.controller.GenericController;
import funcionalidades.geral.viewadapter.GenericViewAdapter;
import infra.exception.BusinessException;
import infra.exception.DBException;
import infra.exception.SystemException;
import infra.model.Entidade;
import infra.util.UtilFunctions;


public class PindaibaMainActivity extends ActionBarActivity {

    // Declaracao de componentes
    ComandaController comandaController;
    GenericController genericController;
    Button btSalvar;
    Button btListar;

    Button btListarTipoUnidadeMedida;
    Button btListarTipoEstabelecimento;
    Button btListarTipoItemMenu;

    EditText editNome;
    EditText editDescricao;
    ListView grupoListView;
    GrupoViewAdapter grupoViewAdapter;
    ListView genericListView;
    GenericViewAdapter genericViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindaiba_main);
        try {
            criarComponentesTela();
        } catch (DBException e) {
            Log.d("CARREGAR DADOS: DB", e.getMessage());
            e.printStackTrace();
            UtilFunctions.exibirAlerta(this, e.getMessage());
        } catch (SystemException e) {
            Log.d("CARREGAR DADOS: System", e.getMessage());
            e.printStackTrace();
            UtilFunctions.exibirAlerta(this, e.getMessage());
        }
    }

    /*
     * Criacao de componentes;
     */
    private void criarComponentesTela() throws DBException, SystemException {

        comandaController = new ComandaController(this);
        genericController = new GenericController(this);

        editNome = (EditText) findViewById(R.id.editNomeGrupo);
        editDescricao = (EditText) findViewById(R.id.editDescricaoGrupo);

        // Botao Salvar
        btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btSalvarAction();
            }
        });

        // Botao Listar
        btListar = (Button) findViewById(R.id.btListar);
        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btListarAction();
            }
        });

        // Botao Listar Tipo Unidade Medida
        btListarTipoUnidadeMedida = (Button) findViewById(R.id.btListarTipoUnidadeMedida);
        btListarTipoUnidadeMedida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btListarGenericAction(new TipoUnidadeMedida());
            }
        });

        // Botao Listar Tipo Estabelecimento
        btListarTipoEstabelecimento = (Button) findViewById(R.id.btListarTipoEstabelecimento);
        btListarTipoEstabelecimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btListarGenericAction(new TipoEstabelecimento());
            }
        });

        // Botao Listar Tipo Item Menu
        btListarTipoItemMenu = (Button) findViewById(R.id.btListarTipoItemMenu);
        btListarTipoItemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btListarGenericAction(new TipoItemMenu());
            }
        });

        // Lista Grupo
        grupoListView = (ListView) findViewById(R.id.listViewGrupo);
        grupoViewAdapter = new GrupoViewAdapter(this, R.layout.layout_list_grupo, new ArrayList<Grupo>());
        grupoListView.setAdapter(grupoViewAdapter);
        carregarGrupo();

        // Lista Generic
        genericListView = (ListView) findViewById(R.id.listViewGeneric);
        genericViewAdapter = new GenericViewAdapter(this, R.layout.layout_generic_list, new ArrayList<String[]>());
        genericListView.setAdapter(genericViewAdapter);
    }

    /*
     * Implementacao do botao Salvar.
     */
    private void btSalvarAction(){
        Grupo grupo = new Grupo();
        grupo.setNome(editNome.getText().toString());
        grupo.setDescricao(editDescricao.getText().toString());

        try {
            comandaController.inserirGrupo(grupo);
        } catch (BusinessException e) {
            Log.d("SALVAR GRUPO: Negocio", e.getMessage());
            e.printStackTrace();
            UtilFunctions.exibirAlerta(this, e.getMessage());
        } catch (SystemException e) {
            Log.d("SALVAR GRUPO: Sistema", e.getMessage());
            e.printStackTrace();
//            UtilFunctions.exibirAlerta(this, e.getMessage());
        } catch (Exception e) {
            Log.d("SALVAR GRUPO: Geral", e.getMessage());
//            UtilFunctions.exibirAlerta(this, e.getMessage());
            e.printStackTrace();
        }
        carregarGrupo();
    }

    private void btListarAction(){
        carregarGrupo();
    }

    private void btListarGenericAction(Entidade entidade){
        try {
            genericController.carregarEntidadeDominio();
        } catch (DBException e) {
            Log.d("Carregar Dominio: DB", e.getMessage());
            e.printStackTrace();
            UtilFunctions.exibirAlerta(this, e.getMessage());
        } catch (SystemException e) {
            Log.d("Carregar Dominio: System", e.getMessage());
            e.printStackTrace();
            UtilFunctions.exibirAlerta(this, e.getMessage());
        }
        ArrayList<String[]> listaDados = new ArrayList<String[]>();
        ArrayList<?> entidades = null;
        try{
            if(entidade instanceof TipoUnidadeMedida){
                entidades = (ArrayList<TipoUnidadeMedida>) genericController.listarTipoUnidadeMedidaById(null);
                for (TipoUnidadeMedida enti: (ArrayList<TipoUnidadeMedida>)entidades ){
                    String [] item = {
                            Integer.toString(enti.get_id()),
                            enti.getNome(),
                            enti.getDescricao()
                    };
                    listaDados.add(item);
                }
            }
            else if(entidade instanceof TipoEstabelecimento){
                entidades = (ArrayList<TipoEstabelecimento>) genericController.listarTipoEstabelecimentoById(null);
                for (TipoEstabelecimento enti: (ArrayList<TipoEstabelecimento>)entidades ){
                    String [] item = {
                            Integer.toString(enti.get_id()),
                            enti.getNome(),
                            enti.getDescricao()
                    };
                    listaDados.add(item);
                }
            }
            else if(entidade instanceof TipoItemMenu){
                entidades = (ArrayList<TipoItemMenu>) genericController.listarTipoItemMenuById(null);
                for (TipoItemMenu enti: (ArrayList<TipoItemMenu>)entidades ){
                    String [] item = {
                            Integer.toString(enti.get_id()),
                            enti.getNome(),
                            enti.getDescricao()
                    };
                    listaDados.add(item);
                }
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }



        carregarGenericList(listaDados);
    }

    /*
     *
     */
    private void carregarGrupo(){
        grupoViewAdapter.getLista().clear();
        try {
            grupoViewAdapter.getLista().addAll(comandaController.listarGrupo());
        } catch (SystemException e) {
            Log.d("LISTAR GRUPO: Geral", e.getMessage());
            UtilFunctions.exibirAlerta(this, e.getMessage());
            e.printStackTrace();
        }
        grupoViewAdapter.notifyDataSetChanged();
    }

    private void carregarGenericList(ArrayList<String[]> listaDados){
        genericViewAdapter.getLista().clear();
        genericViewAdapter.getLista().addAll(listaDados);
        genericViewAdapter.notifyDataSetChanged();
    }

}
