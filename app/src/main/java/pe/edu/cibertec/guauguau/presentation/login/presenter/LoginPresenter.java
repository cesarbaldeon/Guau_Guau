package pe.edu.cibertec.guauguau.presentation.login.presenter;

import javax.inject.Inject;

import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.domain.login_interactor.ILoginInteractor;
import pe.edu.cibertec.guauguau.presentation.login.ILoginContract;

public class LoginPresenter implements ILoginContract.IPresenter {

    ILoginContract.IView view;
    private final ILoginInteractor login_Interactor;

    @Inject
    public LoginPresenter(ILoginInteractor login_Interactor) {
        this.login_Interactor = login_Interactor;
    }


    @Override
    public void attachView(ILoginContract.IView view) {
        this.view = view;
    }

    @Override
    public void detahView() {
        view = null;
    }

    @Override
    public boolean isViewAttched() {
        return  view != null;
    }

    @Override
    public void getLogin(Usuario pUsuario) {

        login_Interactor.getLogin(pUsuario, new ILoginInteractor.ILoginCallBack() {
            @Override
            public void onSuccess(Usuario pUsuario) {
                if(isViewAttched()){
                    view.getLoginSuccess(pUsuario);
                }
            }

            @Override
            public void onError(String errorMsg) {
                if(isViewAttched()) {
                    view.showError(errorMsg);
                }
            }
        });

    }
}
