package pe.edu.cibertec.guauguau.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.1.8:8081/WS_Guau_Guau/";
    private static  Retrofit retrofit = null;

    public static Retrofit getClient(){
         if(retrofit == null) {
             //imprime automaticamente el log del retrofit
  HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
          .setLevel(HttpLoggingInterceptor.Level.BODY);
   OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

              retrofit = new Retrofit.Builder()
                     .baseUrl(BASE_URL)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
         }
         return retrofit;
    }

}
