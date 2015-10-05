package funcionalidades.comanda.viewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.pindaiba.pindaiba.R;
import funcionalidades.comanda.model.Grupo;

/**
 * Created by theo on 28/09/15.
 */
public class GrupoViewAdapter extends ArrayAdapter<Grupo> {

    private List<Grupo> lista;
    private int rowResourceID;


    public GrupoViewAdapter(Context context, int resource, List<Grupo> objects){
        super(context, resource, objects);
        this.lista = objects;
        this.rowResourceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater viewIn = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewOut = viewIn.inflate(this.rowResourceID, null);

        Grupo grupo = lista.get(position);

        if(grupo != null){
            TextView txtItemListIdGrupo = (TextView) viewOut.findViewById(R.id.textListIdGrupo);
            txtItemListIdGrupo.setText(Integer.toString(grupo.get_id()));

            TextView txtItemListNomeGrupo = (TextView) viewOut.findViewById(R.id.textListNomeGrupo);
            txtItemListNomeGrupo.setText(grupo.getNome());

            TextView txtItemListDescricaoGrupo = (TextView) viewOut.findViewById(R.id.textListDescricaoGrupo);
            txtItemListDescricaoGrupo.setText(grupo.getDescricao());
        }
        return viewOut;
    }

    public List<Grupo> getLista() {
        return lista;
    }

    public void setLista(List<Grupo> lista) {
        this.lista = lista;
    }
}
