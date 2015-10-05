package funcionalidades.geral.viewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.pindaiba.pindaiba.R;

/**
 * Created by theo on 28/09/15.
 */
public class GenericViewAdapter extends ArrayAdapter<String[]> {

    private List<String[]> lista;
    private int rowResourceID;


    public GenericViewAdapter(Context context, int resource, List<String[]> objects){
        super(context, resource, objects);
        this.lista = objects;
        this.rowResourceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater viewIn = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewOut = viewIn.inflate(this.rowResourceID, null);

        String[] item = lista.get(position);

        if(item != null && item.length > 0){

            int i =0;
            TextView txtItemListCampo1 = (TextView) viewOut.findViewById(R.id.textListCampo1);
            txtItemListCampo1.setText(item.length>i?item[i]:"---");i++;

            TextView txtItemListCampo2 = (TextView) viewOut.findViewById(R.id.textListCampo2);
            txtItemListCampo2.setText(item.length>i?item[i]:"---");i++;

            TextView txtItemListCampo3 = (TextView) viewOut.findViewById(R.id.textListCampo3);
            txtItemListCampo3.setText(item.length>i?item[i]:"---");i++;

            TextView txtItemListCampo4 = (TextView) viewOut.findViewById(R.id.textListCampo4);
            txtItemListCampo4.setText(item.length>i?item[i]:"---");i++;

            TextView txtItemListCampo5 = (TextView) viewOut.findViewById(R.id.textListCampo5);
            txtItemListCampo5.setText(item.length>i?item[i]:"---");i++;
        }
        return viewOut;
    }

    public List<String[]> getLista() {
        return lista;
    }

    public void setLista(List<String[]> lista) {
        this.lista = lista;
    }
}
