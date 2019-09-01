package pe.edu.cibertec.guauguau.di.module;

import dagger.Module;
import dagger.Provides;
import pe.edu.cibertec.guauguau.domain.canes_interactor.CanesInteractorImpl;
import pe.edu.cibertec.guauguau.domain.canes_interactor.ICanesInteractor;
import pe.edu.cibertec.guauguau.presentation.menu.presenter.MenuPresenter;

@Module
public class MenuModule {

    @Provides
    MenuPresenter provideMenuPresenter(ICanesInteractor canesInteractor){
        return new MenuPresenter(canesInteractor);
    }

    @Provides
    ICanesInteractor provideCanesInteractor(){
        return new CanesInteractorImpl();
    }

}
