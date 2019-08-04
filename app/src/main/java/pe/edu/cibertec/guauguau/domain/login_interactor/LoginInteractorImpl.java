package pe.edu.cibertec.guauguau.domain.login_interactor;


import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.network.ApiClient;
import pe.edu.cibertec.guauguau.network.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorImpl implements ILoginInteractor {


    @Override
    public void getUsuario(Usuario pUsuario, ILoginCallBack callBack) {
        JsonPlaceHolderApi jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);

        Call<Usuario> call = jsonPlaceHolderApi.getUsuario(pUsuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(!response.isSuccessful()){
                    callBack.onError("Code:" + response.code());
                }else{
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
