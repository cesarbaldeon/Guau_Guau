package pe.edu.cibertec.guauguau.presentation.splash.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import pe.edu.cibertec.guauguau.R;
import pe.edu.cibertec.guauguau.presentation.login.view.LoginActivity;
import pe.edu.cibertec.guauguau.presentation.splash.ISplashContract;

public class SplashActivity extends Activity  implements ISplashContract.IView {

    Handler handler;
    final int TIME_SPLASH =1200;
    private ProgressBar progressBarSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler=new Handler();
        progressBarSplash = findViewById(R.id.progressBar);
        gotToPincipal();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBarSplash.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarSplash.setVisibility(View.GONE);
    }

    @Override
    public void gotToPincipal() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },TIME_SPLASH);
    }
}
