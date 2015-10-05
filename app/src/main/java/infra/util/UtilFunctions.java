package infra.util;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by theo on 15/09/15.
 */
public class UtilFunctions {

    /**
     * Exibe um SHORT Toast.
     * @param contexto
     * @param mensagem
     */
    public static void exibirToast(Context contexto , String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_SHORT).show();
    }

    /**
     * Exibe um alerta de notificacao.
     * @param contexto
     * @param mensagem
     */
    public static void exibirAlerta(Context contexto, String mensagem){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(contexto);
        alertDialogBuilder.setMessage(mensagem);
        alertDialogBuilder.setTitle("Notificação");
//        alertDialogBuilder.setIcon(R.drawable.goldandroid);
        alertDialogBuilder.setPositiveButton("Ok",null);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    /**
     * Converte Date em Long para String.
     * @param dataIn
     * @return
     */
    public static String formataData(long dataIn){
        Date data = new Date(dataIn);
        return formataData(data);
    }

    /**
     * Formata data em String.
     * @param dataIn
     * @return
     */
    public static String formataData(Date dataIn){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatador.format(dataIn);
        return data;
    }

    /**
     * Converte Long em Date.
     * @param dataIn
     * @return
     */
    public static Date longToDate(long dataIn){
        Date data = new Date(dataIn);
        return data;
    }

    /**
     * Converte Date em Long.
     * @param dataIn
     * @return
     */
    public static long dateToLong(Date dataIn){
        return dataIn.getTime();
    }

}
