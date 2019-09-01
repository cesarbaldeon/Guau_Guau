package pe.edu.cibertec.guauguau.presentation.menu.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pe.edu.cibertec.guauguau.MyApplication;
import pe.edu.cibertec.guauguau.R;
import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.data.entities.Vacunas;
import pe.edu.cibertec.guauguau.presentation.datosPersonales.view.DatosPersonalesActivity;
import pe.edu.cibertec.guauguau.presentation.menu.IMenuContract;
import pe.edu.cibertec.guauguau.presentation.menu.presenter.MenuPresenter;
import pe.edu.cibertec.guauguau.presentation.vacunas.view.ListaVacunasActivity;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,IMenuContract.IView  {

    private TextView txtusername;
    private TextView txtnombre;
    private View view_nav_menu;
    @Inject
    MenuPresenter presenter;
    private List<Mascotas> mascotasList = new ArrayList<>();
    private List<Vacunas> vacunasList = new ArrayList<>();
    private RecyclerView recyclerViewMenu;
    private CanesAdapter canesAdapter;
    private VacunasAdapter vacunasAdapter;
    private Usuario objusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        view_nav_menu = navigationView.inflateHeaderView(R.layout.nav_header_menu);

        MyApplication application = (MyApplication)getApplication();
        application.getAppComponent().inject(this);
        presenter.attachView(this);

        InicializaParametros();
        SetObjetos();
    }

    private void InicializaParametros() {

        recyclerViewMenu = findViewById(R.id.recyclerViewlistaopciones);
        txtnombre = view_nav_menu.findViewById(R.id.txtnombremenu);
        txtusername = view_nav_menu.findViewById(R.id.txtusernamemenu);

        canesAdapter = new CanesAdapter(mascotasList);
        vacunasAdapter = new VacunasAdapter(vacunasList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewMenu.setLayoutManager(mLayoutManager);

    }

    private void SetObjetos() {

        Bundle busuario = getIntent().getExtras();
        objusuario = (Usuario) busuario.getSerializable("Usuario");

        txtusername.setText(objusuario.getUser_Name().toString());
        txtnombre.setText(objusuario.getNombre() + " " + objusuario.getApellido());
        presenter.getMascota(objusuario);

        canesAdapter.setOnItemClickListener(new ICanesClickListener() {
            @Override
            public void onClick(int position) {
                getVacunasSuccess(mascotasList.get(position));
            }
        });

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_macotas) {
            // Handle the camera action
            mascotasList.clear();
            presenter.getMascota(objusuario);
        } else if (id == R.id.nav_vacunas) {
            vacunasList.clear();
            presenter.getTotalVacunas();
        } else if (id == R.id.nav_perfil) {
            Intent intent = new Intent(this, DatosPersonalesActivity.class);
            startActivity(intent);
        /*} else if (id == R.id.nav_tools) {*/

        } else if (id == R.id.nav_mapas) {

        /*} else if (id == R.id.nav_send) {*/

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMascotasSuccess(List<Mascotas> mascotasList) {
        recyclerViewMenu.setAdapter(canesAdapter);
        this.mascotasList.addAll(mascotasList);
        canesAdapter.notifyDataSetChanged();
    }

    @Override
    public void getVacunasSuccess(Mascotas objMascota) {
        Intent intent = new Intent(this, ListaVacunasActivity.class);
        Bundle bMascota = new Bundle();
        bMascota.putSerializable("Mascota", (Serializable) objMascota);
        intent.putExtras(bMascota);
        startActivity(intent);

    }

    @Override
    public void getTotalVacunasSuccess(List<Vacunas> vacunas) {
        recyclerViewMenu.setAdapter(vacunasAdapter);
        this.vacunasList.addAll(vacunas);
        vacunasAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        presenter.detahView();
        super.onDestroy();
    }

    @Override
    public void onDetachedFromWindow() {
        presenter.detahView();
        super.onDetachedFromWindow();

    }
}
