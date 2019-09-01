package pe.edu.cibertec.guauguau.domain.vacunas_interactor;

import java.util.List;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Vacunas;

public interface IListaVacunasInteractor {


    interface IListaVacunasCallBack{
        void onSuccess(List<Vacunas> listVacunas);
        void onError(String errorMsg);
    }

    void getVacunasXMascotas(Mascotas pObjMascotas, IListaVacunasCallBack callBack);
    void getTotalVacunas(IListaVacunasCallBack callBack);
}
