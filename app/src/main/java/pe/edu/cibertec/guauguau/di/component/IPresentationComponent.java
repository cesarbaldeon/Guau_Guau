package pe.edu.cibertec.guauguau.di.component;

import dagger.Component;
import pe.edu.cibertec.guauguau.di.module.ListaVacunasModule;
import pe.edu.cibertec.guauguau.di.module.LoginModule;
import pe.edu.cibertec.guauguau.di.module.MenuModule;
import pe.edu.cibertec.guauguau.presentation.login.view.LoginActivity;
import pe.edu.cibertec.guauguau.presentation.menu.view.MenuActivity;
import pe.edu.cibertec.guauguau.presentation.vacunas.view.ListaVacunasActivity;


@Component(modules = {LoginModule.class, MenuModule.class, ListaVacunasModule.class})
public interface IPresentationComponent {
    void inject(LoginActivity loginActivity);
    void inject(MenuActivity menuActivity);
    void inject(ListaVacunasActivity listaVacunasActivity);
}
