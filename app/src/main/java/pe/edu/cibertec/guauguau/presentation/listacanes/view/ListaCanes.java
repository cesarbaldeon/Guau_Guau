package pe.edu.cibertec.guauguau.presentation.listacanes.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;

import pe.edu.cibertec.guauguau.R;

public class ListaCanes extends AppCompatActivity {


    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canes);

        recyclerView = findViewById(R.id.lisCanes);



    }
}
