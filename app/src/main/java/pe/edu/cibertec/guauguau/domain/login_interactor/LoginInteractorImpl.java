package pe.edu.cibertec.guauguau.domain.login_interactor;


import android.util.Log;

import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.network.ApiClient;
import pe.edu.cibertec.guauguau.network.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorImpl implements ILoginInteractor {


    @Override
    public void getLogin(Usuario pUsuario, ILoginCallBack callBack) {
        JsonPlaceHolderApi jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);

        Call<Usuario> call = jsonPlaceHolderApi.getLogin(pUsuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(!response.isSuccessful()){
                    callBack.onError("Code:" + response.code());
                }else{
                    Log.d("CB",response.body().getNombre());
                    callBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }
}
