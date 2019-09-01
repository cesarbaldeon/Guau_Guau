package pe.edu.cibertec.guauguau.domain.canes_interactor;

import java.util.List;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Usuario;

public interface ICanesInteractor {

    interface ICanesCallBack{
        void onSuccess(List<Mascotas> listMascotas);
        void onError(String errorMsg);
    }

    void getMascotas_Usuario(Usuario pObjUsuario, ICanesCallBack callBack);

}
