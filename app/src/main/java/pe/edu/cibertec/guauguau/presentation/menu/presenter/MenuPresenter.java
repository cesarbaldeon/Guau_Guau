package pe.edu.cibertec.guauguau.presentation.menu.presenter;

import java.util.List;

import javax.inject.Inject;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.data.entities.Vacunas;
import pe.edu.cibertec.guauguau.domain.canes_interactor.ICanesInteractor;
import pe.edu.cibertec.guauguau.domain.vacunas_interactor.IListaVacunasInteractor;
import pe.edu.cibertec.guauguau.presentation.menu.IMenuContract;

public class MenuPresenter implements IMenuContract.IPresenter {

    IMenuContract.IView view;
    private final ICanesInteractor canesInteractor;
    private final IListaVacunasInteractor vacunasInteractor;

    @Inject
    public MenuPresenter(ICanesInteractor canesInteractor, IListaVacunasInteractor vacunasInteractor) {
        this.canesInteractor = canesInteractor;
        this.vacunasInteractor = vacunasInteractor;
    }

    @Override
    public void attachView(IMenuContract.IView view) {
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
    public void getMascota(Usuario pObjUsuario) {
//aca usaremos un interceptor de la capa domain
        canesInteractor.getMascotas_Usuario(pObjUsuario, new ICanesInteractor.ICanesCallBack() {
            @Override
            public void onSuccess(List<Mascotas> listMascotas) {
                if(isViewAttched()){
                    view.getMascotasSuccess(listMascotas);
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


    @Override
    public void getTotalVacunas() {
        vacunasInteractor.getTotalVacunas(new IListaVacunasInteractor.IListaVacunasCallBack() {
            @Override
            public void onSuccess(List<Vacunas> listVacunas) {
                if(isViewAttched()){
                    view.getTotalVacunasSuccess(listVacunas);
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
