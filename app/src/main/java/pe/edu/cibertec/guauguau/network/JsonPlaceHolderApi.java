package pe.edu.cibertec.guauguau.network;

import com.google.gson.JsonObject;

import java.util.List;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Usuario;
import pe.edu.cibertec.guauguau.data.entities.Vacunas;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @POST("servicios/restapi/va")
    Call<Usuario> getLogin(@Body Usuario pUsuario);
    /*
    @POST("users/new")
    Call<User> createUser(@Body User user);*/
/*
    @Multipart
    @PUT("user/photo")
    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);*/

    @POST("servicios/restapi/vaxma")
    Call<List<Vacunas>> getVacunas(@Body Mascotas pMascota);

    @GET("servicios/restapi/vac")
    Call<List<Vacunas>>getTotalVacunas();


    @POST("servicios/restapi/ma")
    Call<List<Mascotas>> getMascotas(@Body Usuario pUsuario);

}