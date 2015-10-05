package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.ui.ParseLoginBuilder;

import br.com.pindaiba.pindaiba.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private android.support.v7.widget.Toolbar toolbar;
    private TableLayout tableLayout;
    private FragmentDrawer drawerFragment;
    private ParseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarActionBar();

        inicializaNavigatioDrawer();

        inicializaParseLogin();

        displayView(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializaNavigatioDrawer() {

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        Button sair = (Button) findViewById(R.id.botaoSair);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void inicializarActionBar() {

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void inicializaParseLogin() {

        currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {

            TextView usuario = (TextView) findViewById(R.id.username);
            usuario.setText(ParseUser.getCurrentUser().getUsername());

            TextView email = (TextView) findViewById(R.id.email);
            email.setText(ParseUser.getCurrentUser().getEmail());

        } else {

            ParseLoginBuilder builder = new ParseLoginBuilder(MainActivity.this);
            startActivityForResult(builder.build(), 0);

        }
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new MenuNivel1Fragment();
                title = getString(R.string.fragment_menunivel1);
                break;
            case 1:
                fragment = new ComandaIndividualFragment();
                title = getString(R.string.titulo_comanda_individual);
                break;
            case 2:
                fragment = new NovaCobrancaFragment();
                title = getString(R.string.titulo_nova_cobranca);
                break;
            case 3:
                fragment = new HistoricoComandaFragment();
                title = getString(R.string.titulo_historico_comanda);
                break;
            case 4:
                fragment = new HistoricoCobrancaFragment();
                title = getString(R.string.titulo_historico_cobranca);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}
