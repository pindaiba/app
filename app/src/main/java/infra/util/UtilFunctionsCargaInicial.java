package infra.util;

import java.util.ArrayList;

import funcionalidades.comanda.model.ItemMenuPadrao;
import funcionalidades.comanda.model.TipoEstabelecimento;
import funcionalidades.comanda.model.TipoItemMenu;
import funcionalidades.comanda.model.TipoUnidadeMedida;
import infra.model.Entidade;

/**
 * Created by theo on 01/10/15.
 */
public class UtilFunctionsCargaInicial {




    public static ArrayList<TipoUnidadeMedida> getCargaTipoUnidadeMedida(){
        ArrayList<TipoUnidadeMedida> lista = new ArrayList<TipoUnidadeMedida>();
        String[][] arrayTipo = {
                {"litro"     , "Unidade padrão de bebidas, geralmente aplicada a refrigerentes e sucos"},
                {"ml"        , "Unidade padrão de garrafas e latas abaixo de 1 litro"},
                {"porção"    , "Prato com pedaços avulsos, geramente aplicada em tira gostos."},
                {"unidade"   , "Elementos servidos por unidade, como salgados."},
                {"dose"      , "Unidade padrão para destilados."},
                {"duzia"     , "Conjunto especificos de 12 unidades."},
                {"meia duzia", "Conjunto especificos de 6 unidades."},
        };

        for(String [] item: arrayTipo) {
            TipoUnidadeMedida unidadeMedida = new TipoUnidadeMedida();
            unidadeMedida.setNome(item[0]);
            unidadeMedida.setDescricao(item[1]);
            lista.add(unidadeMedida);
        }
        return lista;

    }

    public static ArrayList<TipoEstabelecimento> getCargaTipoEstabelecimento(){
        ArrayList<TipoEstabelecimento> lista = new ArrayList<TipoEstabelecimento>();
        String[][] arrayTipo = {
                {"Restaurante" , "Estabelecimento voltado a serviço de alimentação de refeições"},
                {"Bar"         , "Serviço de venda de bebidas e petiscos"},
                {"Buteco"      , "Serviço de venda de bebidas e peticos de baixo custo."},
                {"Lanchonete"  , "Serviço de venda de lanches"},
                {"Hanburgueria", "Serviço de venda de hangurguer"},
                {"Stake House" , "Serviço de venda de bebidas e carnes "},
        };

        for(String [] tipo: arrayTipo) {
            TipoEstabelecimento item = new TipoEstabelecimento();
            item.setNome(tipo[0]);
            item.setDescricao(tipo[1]);
            lista.add(item);
        }
        return lista;

    }

    public static ArrayList<TipoItemMenu> getCargaTipoItemMenu(){
        ArrayList<TipoItemMenu> lista = new ArrayList<TipoItemMenu>();
        String[][] arrayTipo = {
                {"Cerveja" , ""},
                {"Drink" , ""},
                {"Destilado" , ""},
                {"Petisco" , ""},
                {"Sanduba" , ""},
                {"Refeição" , ""},
                {"Vinho" , ""},
        };

        for(String [] tipo: arrayTipo) {
            TipoItemMenu item = new TipoItemMenu();
            item.setNome(tipo[0]);
            item.setDescricao(tipo[1]);
            lista.add(item);
        }
        return lista;

    }

//    "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
//            "values(1, 'Cerveja Litrão', '', 1, 'litro', 'imgCervejaLitrao', 1);",
//            "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
//            "values(2, 'Cerveja Normal', '', 600, 'ml', 'imgCervejaNormal', 1);",
//            "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
//            "values(3, 'Cerveja Long neck', '', 235, 'ml', 'imgCervejaLongNeck', 1);",
//            "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
//            "values(4, 'Caipirinha de Frutas', '', 200, 'ml', 'imgCaipirinha', 2);",
//            "INSERT INTO ItemMenuPadrao(_id, nome, descricao, quantidade, unidade, idImagem, idTipoItemMenu) " +
//            "values(5, 'Mojito', '', 200, 'ml', 'imgMojito', 2);",

//    public static ArrayList<ItemMenuPadrao> getCargaItemMenuPadrao(){
//        ArrayList<ItemMenuPadrao> lista = new ArrayList<ItemMenuPadrao>();
//        String[][] arrayTipo = {
//                {"" , ""},
//                {"" , ""},
//                {"" , ""},
//                {"" , ""},
//                {"" , ""},
//
//        };
//
//        for(String [] tipo: arrayTipo) {
//            ItemMenuPadrao item = new ItemMenuPadrao();
//            item.setNome(tipo[0]);
//            item.setDescricao(tipo[1]);
//            lista.add(item);
//        }
//        return lista;
//
//    }

}



