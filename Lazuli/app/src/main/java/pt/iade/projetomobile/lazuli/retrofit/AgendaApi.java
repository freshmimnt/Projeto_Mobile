package pt.iade.projetomobile.lazuli.retrofit;

import pt.iade.projetomobile.lazuli.models.Agenda;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

public interface AgendaApi {

    @POST("/agenda/save")
    Call<Agenda> save(@Body Agenda agenda);



}
