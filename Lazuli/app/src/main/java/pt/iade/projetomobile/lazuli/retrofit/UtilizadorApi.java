package pt.iade.projetomobile.lazuli.retrofit;

import java.util.List;

import pt.iade.projetomobile.lazuli.models.User;
import retrofit2.Call;
import retrofit2.http.*;

public interface UtilizadorApi {

    @GET("/user/get")
    Call<List<User>> getAllUsers();

    @POST("/user/save")
    Call<User> save(@Body User user);

}
