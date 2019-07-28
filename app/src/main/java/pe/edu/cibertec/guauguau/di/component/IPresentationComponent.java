package pe.edu.cibertec.guauguau.di.component;

import dagger.Component;
import pe.edu.cibertec.guauguau.di.module.LoginModule;
import pe.edu.cibertec.guauguau.presentation.login.view.LoginActivity;


@Component(modules = {LoginModule.class})
public interface IPresentationComponent {
    void inject(LoginActivity loginActivity);
}
