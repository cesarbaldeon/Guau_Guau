package pe.edu.cibertec.guauguau.network;

import com.google.gson.JsonObject;

import java.util.List;

import pe.edu.cibertec.guauguau.data.entities.Mascotas;
import pe.edu.cibertec.guauguau.data.entities.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("user")
    Call<Usuario> getUsuario(@Query("user_Name") String  pUsername,@Query("password") String pPwd );
    /*
    @POST("users/new")
    Call<User> createUser(@Body User user);*/
/*
    @Multipart
    @PUT("user/photo")
    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);*/

    @POST("users/new")
    Call<Usuario> createUser(@Body Usuario pUsuario);


    @GET("/comments")
    Call<List<Mascotas>> getMascotas(@Query("postId") int userId);

}