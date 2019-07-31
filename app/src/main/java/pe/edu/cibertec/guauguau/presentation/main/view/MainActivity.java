package pe.edu.cibertec.guauguau.presentation.main.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import pe.edu.cibertec.guauguau.R;
import pe.edu.cibertec.guauguau.data.entities.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario busuario = (Usuario) getIntent().getSerializableExtra("Usuario");



    }
}
