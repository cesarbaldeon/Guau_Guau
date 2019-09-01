package pe.edu.cibertec.guauguau.presentation.vacunas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pe.edu.cibertec.guauguau.MyApplication;
import pe.edu.cibertec.guauguau.R;
import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Vacunas;
import pe.edu.cibertec.guauguau.presentation.vacunas.IListaVacunasContract;
import pe.edu.cibertec.guauguau.presentation.vacunas.presenter.ListaVacunasPresenter;

public class ListaVacunasActivity extends AppCompatActivity implements IListaVacunasContract.IView {

    private Mascotas objMascota;
    private RecyclerView recyclerViewComment;
    private ListaVacunasAdapter listaVacunasAdapter;
    private List<Vacunas> vacunasList = new ArrayList<>();

    @Inject
    ListaVacunasPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vacunas);

        MyApplication application = (MyApplication)getApplication();
        application.getAppComponent().inject(this);
        presenter.attachView(this);

        InicializaParametros();
        SetObjetos();
    }

    private void SetObjetos() {
        Bundle busuario = getIntent().getExtras();
        objMascota = (Mascotas) busuario.getSerializable("Mascota");
        presenter.getVacunas(objMascota);
    }

    private void InicializaParametros() {
        recyclerViewComment = findViewById(R.id.recyclerViewlistaovacunas);

        listaVacunasAdapter = new ListaVacunasAdapter(vacunasList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewComment.setLayoutManager(mLayoutManager);
        recyclerViewComment.setAdapter(listaVacunasAdapter);
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getVacunasSuccess(List<Vacunas> vacunasList) {
        this.vacunasList.addAll(vacunasList);
        listaVacunasAdapter.notifyDataSetChanged();
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
