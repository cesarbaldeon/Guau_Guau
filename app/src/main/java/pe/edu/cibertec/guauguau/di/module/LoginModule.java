package pe.edu.cibertec.guauguau.di.module;


import dagger.Module;
import dagger.Provides;
import pe.edu.cibertec.guauguau.domain.login_interactor.ILoginInteractor;
import pe.edu.cibertec.guauguau.domain.login_interactor.LoginInteractorImpl;
import pe.edu.cibertec.guauguau.presentation.login.presenter.LoginPresenter;

@Module
public class LoginModule {

    @Provides
    LoginPresenter provideLoginPresenter(ILoginInteractor interactor){
        return new LoginPresenter(interactor);
    }

    @Provides
    ILoginInteractor provideLoginInteractor(){
        return new LoginInteractorImpl();
    }

}
