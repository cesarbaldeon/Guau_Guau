package pe.edu.cibertec.guauguau.presentation.login.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import pe.edu.cibertec.guauguau.MyApplication;
import pe.edu.cibertec.guauguau.R;
import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.presentation.login.ILoginContract;
import pe.edu.cibertec.guauguau.presentation.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginContract.IView {

   // @Inject
    //LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // MyApplication application = (MyApplication)getApplication();

       // application.getAppComponent().inject(this);
       // presenter.attachView(this);


    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void getUsuariouccess(Usuario pUsuario) {

    }

    @Override
    public void gotToPincipal(int userId) {

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
}
