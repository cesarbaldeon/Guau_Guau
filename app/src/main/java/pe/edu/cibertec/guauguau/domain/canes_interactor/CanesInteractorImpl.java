package pe.edu.cibertec.guauguau.domain.canes_interactor;

import java.util.List;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.network.ApiClient;
import pe.edu.cibertec.guauguau.network.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CanesInteractorImpl implements ICanesInteractor{

    @Override
    public void getMascotas_Usuario(Usuario pObjUsuario, ICanesCallBack callBack) {

        JsonPlaceHolderApi jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);

        Call<List<Mascotas>> call = jsonPlaceHolderApi.getMascotas(pObjUsuario);

        call.enqueue(new Callback<List<Mascotas>>() {
            @Override
            public void onResponse(Call<List<Mascotas>> call, Response<List<Mascotas>> response) {
                if(!response.isSuccessful()){
                    callBack.onError("Code:" + response.code());
                }else{
                    callBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Mascotas>> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });

    }

}
