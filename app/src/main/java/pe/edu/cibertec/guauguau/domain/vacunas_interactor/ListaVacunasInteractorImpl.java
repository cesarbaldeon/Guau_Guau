package pe.edu.cibertec.guauguau.domain.vacunas_interactor;

import java.util.List;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Vacunas;
import pe.edu.cibertec.guauguau.network.ApiClient;
import pe.edu.cibertec.guauguau.network.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaVacunasInteractorImpl implements IListaVacunasInteractor {

    @Override
    public void getVacunasXMascotas(Mascotas pObjMascotas, IListaVacunasCallBack callBack) {
        JsonPlaceHolderApi jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);

        Call<List<Vacunas>> call = jsonPlaceHolderApi.getVacunas(pObjMascotas);

        call.enqueue(new Callback<List<Vacunas>>() {
            @Override
            public void onResponse(Call<List<Vacunas>> call, Response<List<Vacunas>> response) {
                if(!response.isSuccessful()){
                    callBack.onError("Code:" + response.code());
                }else{
                    callBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Vacunas>> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getTotalVacunas(IListaVacunasCallBack callBack) {
        JsonPlaceHolderApi jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);

        Call<List<Vacunas>> call = jsonPlaceHolderApi.getTotalVacunas();

        call.enqueue(new Callback<List<Vacunas>>() {
            @Override
            public void onResponse(Call<List<Vacunas>> call, Response<List<Vacunas>> response) {
                if(!response.isSuccessful()){
                    callBack.onError("Code:" + response.code());
                }else{
                    callBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Vacunas>> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }
}
