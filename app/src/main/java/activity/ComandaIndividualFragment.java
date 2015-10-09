package activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;

import br.com.pindaiba.pindaiba.R;


public class ComandaIndividualFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    String[] dataArray = new String[]{"Item 1","Item 2","Item 3","Item 4","Item 5","Item 6","Item 7","Item8","Item8","Item8","Item8","Item8","Item8","Item8","Item8","Item8","Item8","Item8","Item8","Item8","Item8","Item8","Item8"};

    public ComandaIndividualFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comanda_individual, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.listaitens);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ComandaIndividualFragmentRecyclerViewAdapter(dataArray);
        recyclerView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}