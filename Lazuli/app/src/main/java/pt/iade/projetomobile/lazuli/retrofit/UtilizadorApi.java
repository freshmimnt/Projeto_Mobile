package pt.iade.projetomobile.lazuli.retrofit;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import pt.iade.projetomobile.lazuli.models.User;
import retrofit2.Call;
import retrofit2.http.*;

public interface UtilizadorApi {

    @GET("/user/get")
    Call<List<User>> getAllUsers();

    @GET("/user/get/{id}")
    Call<User> getUserById(@Path("id") int id);

    @POST("/user/save")
    Call<User> save(@Body User user);

    @POST("/user/authenticate")
    Call<User> authenticateUser(@Body Map<String, String> credentials);

    @DELETE("/user/delete/{id}")
    Call<ResponseBody> deleteUser(@Path("id") int id);

}
