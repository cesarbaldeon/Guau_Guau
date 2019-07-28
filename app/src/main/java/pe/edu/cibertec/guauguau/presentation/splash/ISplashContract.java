package pe.edu.cibertec.guauguau.presentation.splash;

public interface ISplashContract {

    interface IView{
        void showError(String errorMsg);
        void showProgressBar();
        void hideProgressBar();
        void gotToPincipal();
    }

    interface IPresenter{
        void attachView(ISplashContract.IView view);
        void detahView();
        boolean isViewAttched();
    }
}
