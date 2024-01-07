package pt.iade.projetomobile.lazuli.retrofit;
import pt.iade.projetomobile.lazuli.models.UCItem;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;
public interface UCApi {

    @GET("/uc/get")
    Call<List<UCItem>> getAllUcs();

    @POST("/uc/add")
    Call<UCItem> save(@Body UCItem ucItem);

    @PUT("/uc/update/{id}")
    Call<UCItem> update(@Path("id") int id, @Body UCItem ucItem);


}
