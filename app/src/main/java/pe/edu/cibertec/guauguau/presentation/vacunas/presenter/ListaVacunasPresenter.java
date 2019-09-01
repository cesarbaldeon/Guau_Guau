package pe.edu.cibertec.guauguau.presentation.vacunas.presenter;

import java.util.List;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Vacunas;
import pe.edu.cibertec.guauguau.domain.vacunas_interactor.IListaVacunasInteractor;
import pe.edu.cibertec.guauguau.presentation.vacunas.IListaVacunasContract;

public class ListaVacunasPresenter implements IListaVacunasContract.IPresenter {

    IListaVacunasContract.IView view;
    private final IListaVacunasInteractor listavacunasInteractor;

    public ListaVacunasPresenter(IListaVacunasInteractor listavacunasInteractor) {
        this.listavacunasInteractor = listavacunasInteractor;
    }


    @Override
    public void attachView(IListaVacunasContract.IView view) {
        this.view = view;
    }

    @Override
    public void detahView() {
        view = null;
    }

    @Override
    public boolean isViewAttched() {
        return view !=null;
    }


    @Override
    public void getVacunas(Mascotas pObjMascotas) {

        listavacunasInteractor.getVacunasXMascotas(pObjMascotas, new IListaVacunasInteractor.IListaVacunasCallBack() {
            @Override
            public void onSuccess(List<Vacunas> listVacunas) {
                if(isViewAttched()){
                    view.getVacunasSuccess(listVacunas);
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
