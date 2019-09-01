package pe.edu.cibertec.guauguau.presentation.vacunas;

import java.util.List;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Vacunas;

public interface IListaVacunasContract {

    interface IView{
        void showError(String errorMsg);
        void getVacunasSuccess(List<Vacunas> vacunasList);
    }

    interface IPresenter{
        void attachView(IListaVacunasContract.IView view);
        void detahView();
        boolean isViewAttched();
        void getVacunas(Mascotas pObjMascotas);
    }
}
