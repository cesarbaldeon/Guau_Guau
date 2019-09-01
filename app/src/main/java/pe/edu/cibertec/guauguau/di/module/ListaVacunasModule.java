package pe.edu.cibertec.guauguau.di.module;

import dagger.Module;
import dagger.Provides;
import pe.edu.cibertec.guauguau.domain.vacunas_interactor.IListaVacunasInteractor;
import pe.edu.cibertec.guauguau.domain.vacunas_interactor.ListaVacunasInteractorImpl;
import pe.edu.cibertec.guauguau.presentation.vacunas.presenter.ListaVacunasPresenter;


@Module
public class ListaVacunasModule {

    @Provides
    ListaVacunasPresenter provideListaVacunasPresenter(IListaVacunasInteractor listavacunasInteractor){
        return new ListaVacunasPresenter(listavacunasInteractor);
    }

    @Provides
    IListaVacunasInteractor provideListaVacunasInteractor(){
        return new ListaVacunasInteractorImpl();
    }

}
