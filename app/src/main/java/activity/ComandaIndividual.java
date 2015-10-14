package activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import br.com.pindaiba.pindaiba.R;

public class ComandaIndividual extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda_individual);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ComandaIndividualViewPageAdapter adapter = new ComandaIndividualViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ComandaIndividualFragment(), "TODOS");
        adapter.addFragment(new ComandaIndividualComidasFragment(), "COMIDAS");
        adapter.addFragment(new ComandaIndividualBebidasFragment(), "BEBIDAS");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_comanda_individual, menu);

        MenuItem busca = menu.findItem(R.id.buscar_item_comanda);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(busca);
        searchView.setQueryHint("Critério de busca");

        MenuItem editar = menu.findItem(R.id.editar_nome_comanda);
        SearchView editarNomeComanda = (SearchView) MenuItemCompat.getActionView(editar);
        editarNomeComanda.setIconifiedByDefault(true);
        editarNomeComanda.setQueryHint("Nome da Comanda");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.editar_nome_comanda:
                editarNomeComanda();
                return true;
            case R.id.buscar_item_comanda:
                buscaComanda();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void buscaComanda() {
        
    }

    private void editarNomeComanda() {

    }
}

