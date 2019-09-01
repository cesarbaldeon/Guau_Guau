package pe.edu.cibertec.guauguau.presentation.menu;

import java.util.List;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Usuario;

public interface IMenuContract {

    interface IView{
        void showError(String errorMsg);
        void getMascotasSuccess(List<Mascotas> mascotasList);
    }

    interface IPresenter{
        void attachView(IMenuContract.IView view);
        void detahView();
        boolean isViewAttched();
        void getMascota(Usuario pObjUsuario);
    }
}
