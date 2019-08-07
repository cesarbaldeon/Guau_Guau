package pe.edu.cibertec.guauguau.presentation.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import javax.inject.Inject;

import pe.edu.cibertec.guauguau.MyApplication;
import pe.edu.cibertec.guauguau.R;
import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.presentation.login.ILoginContract;
import pe.edu.cibertec.guauguau.presentation.login.presenter.LoginPresenter;
import pe.edu.cibertec.guauguau.presentation.main.view.MainActivity;
import pe.edu.cibertec.guauguau.presentation.menu.view.MenuActivity;
import pe.edu.cibertec.guauguau.presentation.splash.view.SplashActivity;

public class LoginActivity extends AppCompatActivity implements ILoginContract.IView, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    @Inject
    LoginPresenter presenter;

      Button btnAceptar;
      EditText edtCorreo, edtClave;
      CheckBox ckbClave;
    Usuario objUsuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnAceptar = findViewById(R.id.btnAceptar);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtClave =findViewById(R.id.edtClave);
        ckbClave = findViewById(R.id.ckbClave);

        MyApplication application = (MyApplication)getApplication();

        application.getAppComponent().inject(this);
        presenter.attachView(this);
        btnAceptar.setOnClickListener(this);
        //ckbClave.setOnClickListener(this);
        ckbClave.setOnCheckedChangeListener(this);
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getUsuariouccess(Usuario pUsuario) {

        if(pUsuario != null)
            gotToPincipal(pUsuario);
        else
            Toast.makeText(this,"Usuario o   Clave incorrecto", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void gotToPincipal(Usuario pUsuario) {

        Intent intent = new Intent(this, MainActivity.class);
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
<<<<<<< HEAD
                else{
                    objUsuario.setUser_Name(eCorreo);
                    objUsuario.setPassword(eClave);
                    presenter.getUsuario(objUsuario);
                }


=======
                else {
                    //presenter.getUsuario(eCorreo,eClave);
                    Intent intent= new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
>>>>>>> Feature_CE
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
