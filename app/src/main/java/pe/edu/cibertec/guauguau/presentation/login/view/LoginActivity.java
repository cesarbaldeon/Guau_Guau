package pe.edu.cibertec.guauguau.presentation.login.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import javax.inject.Inject;

import pe.edu.cibertec.guauguau.MyApplication;
import pe.edu.cibertec.guauguau.R;
import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.presentation.login.ILoginContract;
import pe.edu.cibertec.guauguau.presentation.login.presenter.LoginPresenter;
import pe.edu.cibertec.guauguau.presentation.menu.view.MenuActivity;
import pe.edu.cibertec.guauguau.presentation.recuperaClave.view.RecuperaClave;
import pe.edu.cibertec.guauguau.presentation.registrarse.view.Registrarse;

public class LoginActivity extends AppCompatActivity implements ILoginContract.IView, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    @Inject
    LoginPresenter presenter;

    Button btnAceptar;
    EditText edtCorreo, edtClave;
    CheckBox ckbClave;
    TextView txtRecuperaClave;
    TextView txtRegistrarse;
    TextView txtTitulo;
   /* String fonts = "fonts/Drop the Game - TTF.ttf";*/
    Usuario objUsuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnAceptar = findViewById(R.id.btnAceptar);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtClave =findViewById(R.id.edtClave);
        ckbClave = findViewById(R.id.ckbClave);
        txtRecuperaClave = findViewById(R.id.txtRecuperaClave);
        txtRegistrarse = findViewById(R.id.txtRegistrar);
        MyApplication application = (MyApplication)getApplication();

        txtTitulo = findViewById(R.id.txtTitulo);
        application.getAppComponent().inject(this);
        presenter.attachView(this);
        btnAceptar.setOnClickListener(this);
        txtRecuperaClave.setOnClickListener(this);
        txtRegistrarse.setOnClickListener(this);
        //ckbClave.setOnClickListener(this);
        ckbClave.setOnCheckedChangeListener(this);

       /* Typeface fuente = Typeface.createFromAsset(getAssets(),fonts);
        if(fuente != null)
        {
            txtTitulo.setTypeface(fuente);
        }*/
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLoginSuccess(Usuario pUsuario) {

        if(pUsuario != null)
            gotToPincipal(pUsuario);
        else
            Toast.makeText(this,"Usuario o   Clave incorrecto", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void gotToPincipal(Usuario pUsuario) {

        Intent intent = new Intent(this, MenuActivity.class);
        Bundle bUsuario = new Bundle();
        bUsuario.putSerializable("Usuario", (Serializable) pUsuario);
        intent.putExtras(bUsuario);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
       // presenter.detahView();
        super.onDestroy();
    }

    @Override
    public void onDetachedFromWindow() {
        //presenter.detahView();
        super.onDetachedFromWindow();

    }

    @Override
    public void onClick(View view) {

       int id_button =  view.getId();

        switch(id_button){
            case R.id.btnAceptar:

                String eCorreo = String.valueOf(edtCorreo.getText());
                String eClave = String.valueOf(edtClave.getText());

                if(eCorreo.equals("") || eClave.equals(""))
                    Toast.makeText(this,"Ingrese datos", Toast.LENGTH_SHORT).show();
                else{
                    objUsuario.setUser_Name(eCorreo);
                    objUsuario.setPassword(eClave);
                    presenter.getLogin(objUsuario);
                }
                break;
            case R.id.txtRecuperaClave:
                Intent intentRecupera= new Intent(LoginActivity.this, RecuperaClave.class);
                startActivity(intentRecupera);
                //finish();
                break;
            case R.id.txtRegistrar:
                Intent intentRegistrarse= new Intent(LoginActivity.this, Registrarse.class);
                startActivity(intentRegistrarse);
                //finish();
                break;

        }

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if (ckbClave.isChecked()) {
            // show password
            edtClave.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            // hide password
            edtClave.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
