package pe.edu.cibertec.guauguau;

import android.app.Application;

import pe.edu.cibertec.guauguau.di.component.DaggerIPresentationComponent;
import pe.edu.cibertec.guauguau.di.component.IPresentationComponent;
import pe.edu.cibertec.guauguau.di.module.LoginModule;

public class MyApplication extends Application {

    private IPresentationComponent appComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        InicializarComponent();
    }

    void InicializarComponent(){
        appComponent = DaggerIPresentationComponent.builder()
                .loginModule(new LoginModule())
                .build();
    }

    public IPresentationComponent getAppComponent(){
        return appComponent;
    }

}
