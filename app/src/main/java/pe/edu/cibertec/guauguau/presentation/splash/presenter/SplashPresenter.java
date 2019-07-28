package pe.edu.cibertec.guauguau.presentation.splash.presenter;

import pe.edu.cibertec.guauguau.presentation.splash.ISplashContract;

public class SplashPresenter implements ISplashContract.IPresenter {

    ISplashContract.IView view;

    @Override
    public void attachView(ISplashContract.IView view) {
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
}
