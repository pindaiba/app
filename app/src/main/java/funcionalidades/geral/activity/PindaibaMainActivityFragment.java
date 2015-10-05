package funcionalidades.geral.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.com.pindaiba.pindaiba.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class PindaibaMainActivityFragment extends Fragment {

    public PindaibaMainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_pindaiba_main, container, false);
    }


}
