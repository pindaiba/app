package infra.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import infra.annotation.Column;
import infra.annotation.Table;
import infra.exception.SystemException;
import infra.model.Entidade;

/**
 * Created by theo on 17/09/15.
 */
public class UtilFunctionsReflection {



    public static Object executarMetodo(Object objeto, String metodo, Object... paramentros) throws SystemException {

        Object dadoRetorno = null;

        Class<?> clazz;
        try {
            clazz = Class.forName(objeto.getClass().getName());
        } catch (ClassNotFoundException e) {
            throw new SystemException("Não foi possível realizar o load da classe " + objeto.getClass().getName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(metodo)) {
                try {
                    if(paramentros != null && paramentros.length > 0){
                        dadoRetorno = method.invoke(objeto, paramentros);
                    }
                    else{
                        dadoRetorno = method.invoke(objeto);
                    }

                } catch (Exception e) {
                    throw new SystemException("Não foi possível invocar o método " + objeto.getClass().getName()+"."+ metodo + "("+paramentros[0].getClass().getName()+")");
                }
            }
        }

        return dadoRetorno;
    }

    public static String getTableAnnotation(Object entidade) throws SystemException{
        Class<?> clazz;
        try {
            clazz = Class.forName(entidade.getClass().getName());
        } catch (ClassNotFoundException e) {
            throw new SystemException("Não foi possível realizar o load da classe " + entidade.getClass().getName());
        }

        for (Annotation anote : clazz.getAnnotations()){
            anote.annotationType();
        }
//        if(!clazz.isAnnotationPresent(Table.class)){
//            throw new SystemException("Não foi possivel identificar a Annotation Table na classe " + clazz.getName());
//        }

        Table annotationTable = clazz.getAnnotation(Table.class);

//        return annotationTable.nome();
        String className = clazz.getName().replace(clazz.getPackage().getName() + ".", "");
        return className;
    }

//    public static String getTableAnnotation(Class<?> clazz) throws SystemException{
//
//        if(!clazz.isAnnotationPresent(Table.class)){
//            throw new SystemException("Não foi possivel identificar a Annotation Table na classe " + clazz.getName());
//        }
//
//        Table annotationTable = clazz.getAnnotation(Table.class);
//
//        return annotationTable.nome();
//    }

//    public static Map<String, Column> getColumnAnnotation(Class<?> clazz) throws SystemException{
//
//        Map<String, Column> mapaAnnotation = new HashMap<String, Column>();
//
//        for(Field field: clazz.getDeclaredFields()){
//
//            if(field.isAnnotationPresent(Column.class)){
//                Column annotationColumn = field.getAnnotation(Column.class);
//                mapaAnnotation.put(field.getName(), annotationColumn);
//            }
//        }
//
//        return mapaAnnotation.size()>0?mapaAnnotation:null;
//    }

    public static void carregarAtributos(Cursor cursor, Entidade entidade) throws SystemException {
        Class<?> clazz;


        try {
            clazz = Class.forName(entidade.getClass().getName());
        } catch (ClassNotFoundException e) {
            throw new SystemException("Não foi possível realizar o load da classe " + entidade.getClass().getName());
        }


        for(Field field: clazz.getDeclaredFields()){

            if(field.isAnnotationPresent(Column.class)){
                Column annotationColumn = field.getAnnotation(Column.class);
                String campoTabela   = annotationColumn.nome();
                String mapeamento = annotationColumn.mapeamentoAtributo();

                String xPath = !mapeamento.equals("")?mapeamento:field.getName();
                Object dadoRetorno = getValorEL(entidade, xPath);


//                 cursor.getColumnIndex(campoTabela)

//                if(dadoRetorno instanceof String){
//                    values.put(campoTabela, (String)dadoRetorno);
//                }
//                else if(dadoRetorno instanceof Date){
//                    values.put(campoTabela, UtilFunctions.dateToLong((Date)dadoRetorno));
//                }
//                else if(dadoRetorno instanceof Integer){
//                    values.put(campoTabela, (Integer)dadoRetorno);
//                }
//                else if(dadoRetorno instanceof BigDecimal){
//                    values.put(campoTabela, ((BigDecimal)dadoRetorno).doubleValue());
//                }
//                else if(dadoRetorno instanceof Double){
//                    values.put(campoTabela, (Double) dadoRetorno);
//                }
//                else if(dadoRetorno instanceof Long){
//                    values.put(campoTabela, (Long)dadoRetorno);
//                }

            }
        }

    }


    public static void setarValues(ContentValues values, Entidade entidade) throws SystemException {
        Class<?> clazz;

        try {
            clazz = Class.forName(entidade.getClass().getName());
        } catch (ClassNotFoundException e) {
            throw new SystemException("Não foi possível realizar o load da classe " + entidade.getClass().getName());
        }


        for (Field field : clazz.getDeclaredFields()) {

//            if(field.isAnnotationPresent(Column.class)){
//                Column annotationColumn = field.getAnnotation(Column.class);
            String campoTabela = field.getName();
//                String mapeamento = annotationColumn.mapeamentoAtributo();

//                String xPath = !mapeamento.equals("")?mapeamento:field.getName();
            Object dadoRetorno = getValorEL(entidade, campoTabela);


            if (dadoRetorno instanceof String) {
                values.put(campoTabela, (String) dadoRetorno);
            } else if (dadoRetorno instanceof Date) {
                values.put(campoTabela, UtilFunctions.dateToLong((Date) dadoRetorno));
            } else if (dadoRetorno instanceof Integer) {
                values.put(campoTabela, (Integer) dadoRetorno);
            } else if (dadoRetorno instanceof BigDecimal) {
                values.put(campoTabela, ((BigDecimal) dadoRetorno).doubleValue());
            } else if (dadoRetorno instanceof Double) {
                values.put(campoTabela, (Double) dadoRetorno);
            } else if (dadoRetorno instanceof Long) {
                values.put(campoTabela, (Long) dadoRetorno);
            }

//            }
        }
    }

    public static void setarValues(ContentValues values, Entidade entidade, int i) throws SystemException {
        Class<?> clazz;

        try {
            clazz = Class.forName(entidade.getClass().getName());
        } catch (ClassNotFoundException e) {
            throw new SystemException("Não foi possível realizar o load da classe " + entidade.getClass().getName());
        }


        for(Field field: clazz.getDeclaredFields()){

            if(field.isAnnotationPresent(Column.class)){
                Column annotationColumn = field.getAnnotation(Column.class);
                String campoTabela   = annotationColumn.nome();
                String mapeamento = annotationColumn.mapeamentoAtributo();

                String xPath = !mapeamento.equals("")?mapeamento:field.getName();
                Object dadoRetorno = getValorEL(entidade, xPath);


                if(dadoRetorno instanceof String){
                    values.put(campoTabela, (String)dadoRetorno);
                }
                else if(dadoRetorno instanceof Date){
                    values.put(campoTabela, UtilFunctions.dateToLong((Date)dadoRetorno));
                }
                else if(dadoRetorno instanceof Integer){
                    values.put(campoTabela, (Integer)dadoRetorno);
                }
                else if(dadoRetorno instanceof BigDecimal){
                    values.put(campoTabela, ((BigDecimal)dadoRetorno).doubleValue());
                }
                else if(dadoRetorno instanceof Double){
                    values.put(campoTabela, (Double) dadoRetorno);
                }
                else if(dadoRetorno instanceof Long){
                    values.put(campoTabela, (Long)dadoRetorno);
                }

            }
        }

    }

//    public static void setarValues_(ContentValues values, Entidade entidade) throws SystemException{
//        Object dadoRetorno = null;
//        Class<?> clazz;
//
//
//        try {
//            clazz = Class.forName(entidade.getClass().getName());
//        } catch (ClassNotFoundException e) {
//            throw new SystemException("Não foi possível realizar o load da classe " + entidade.getClass().getName());
//        }
//
//        // Verificar se a anotacao existe.
//        getTableAnnotation(entidade);
//
//        Map<String, Column> mapaAnnotation = getColumnAnnotation(clazz);
//
//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method method : methods) {
//            if (method.getName().indexOf("get") > -1) {
//
//                Column annotationColumn = mapaAnnotation.get(method.getName().toLowerCase().replace("get",""));
//                if(annotationColumn != null){
//
//                }
//
//                try {
//
//                    dadoRetorno = method.invoke(entidade);
//                    String atributo = annotationColumn.nome();
//                    Object tipo = method.getReturnType();
//
//                    if(!annotationColumn.mapeamentoAtributo().equals("")){
//                        Integer id = ((Entidade)dadoRetorno).get_id();
//                        dadoRetorno = id;
//                        tipo = Integer.class;
//                    }
//
//                    if(tipo instanceof String){
//                        values.put(atributo, (String)dadoRetorno);
//                    }
//                    else if(tipo instanceof Date){
//                        values.put(atributo, UtilFunctions.dateToLong((Date)dadoRetorno));
//                    }
//                    else if(tipo instanceof Integer){
//                        values.put(atributo, (Integer)dadoRetorno);
//                    }
//                    else if(tipo instanceof BigDecimal){
//                        values.put(atributo, ((BigDecimal)dadoRetorno).doubleValue());
//                    }
//                    else if(tipo instanceof Double){
//                        values.put(atributo, (Double) dadoRetorno);
//                    }
//                    else if(tipo instanceof Long){
//                        values.put(atributo, (Long)dadoRetorno);
//                    }
//
//                } catch (Exception e) {
//                    throw new SystemException("Não foi possível invocar o método " + entidade.getClass().getName()+"."+ method + "()");
//                }
//            }
//        }
//    }


    public static Object getValorEL(Object obj, String xPath){
        try
        {
            String[] pathAtributo = xPath.split("\\.");
            Object ob = getValorAtributoPath(obj, pathAtributo, 0);

            return ob;
        }
        catch (Exception e)
        {
            Log.d("UtilFunctionsReflection", "Falha ao resolver o atributo por EL: " + xPath + " na classe " + obj.getClass().getName());
        }

        return null;
    }


    private static Object getValorAtributoPath(Object obj, String[] pathAtributo, int indice) throws NoSuchFieldException, Exception{

        Field f = obj.getClass().getDeclaredField(pathAtributo[indice]);
        f.setAccessible(true);

        // verifica se este é o ultimo indice, se sim, retorna o atributo
        // senão, continua a recursividade
        if (pathAtributo.length == (indice + 1)) {

            if(obj == null) {
                return null;
            }
            else if(f.get(obj) instanceof Integer) {

                return f.get(obj);

            }
            else if(f.get(obj) instanceof BigDecimal) {

                return new BigDecimal(f.get(obj).toString());
            }

            return f.get(obj);

        } else {
            return getValorAtributoPath(f.get(obj), pathAtributo, indice + 1);
        }
    }

}
