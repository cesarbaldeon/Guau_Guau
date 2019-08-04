package pe.edu.cibertec.guauguau.presentation.login;

import pe.edu.cibertec.guauguau.data.entities.Usuario;

public interface ILoginContract {

    interface IView{
        void showError(String errorMsg);
        void getUsuariouccess(Usuario pUsuario);
        void gotToPincipal(Usuario pUsuario);
    }

     interface IPresenter{
        void attachView(ILoginContract.IView view);
        void detahView();
        boolean isViewAttched();
        void getUsuario(Usuario pUsuario);
    }


}
