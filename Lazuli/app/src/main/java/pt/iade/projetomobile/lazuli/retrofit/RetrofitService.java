package pt.iade.projetomobile.lazuli.retrofit;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit;
    private UCApi ucApi;

    public RetrofitService() {
        initializeRetrofit();
    }

    private void initializeRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.50.133:8080")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    private void initializeUCApi() {
        ucApi = retrofit.create(UCApi.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public CursoApi getCursoApi() {
        return retrofit.create(CursoApi.class);
    }

    public UCApi getUcApi() {
        return ucApi;
    }
}


