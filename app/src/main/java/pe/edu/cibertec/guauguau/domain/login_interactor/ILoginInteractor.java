package pe.edu.cibertec.guauguau.domain.login_interactor;

import pe.edu.cibertec.guauguau.data.entities.Usuario;

public interface ILoginInteractor {

    interface ILoginCallBack{
        void onSuccess(Usuario pUsuario);
        void onError(String errorMsg);
    }

    void getUsuario(Usuario pUsuario,ILoginCallBack callBack);

}
