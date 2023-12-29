package pt.iade.projetomobile.lazuli.retrofit;

import java.util.List;

import pt.iade.projetomobile.lazuli.models.Curso;
import retrofit2.Call;
import retrofit2.http.*;

public interface CursoApi {

    @GET("/curso/get")
    Call<List<Curso>> getAllCursos();

}
