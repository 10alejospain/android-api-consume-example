package example.apiuseexample.rest;

import java.util.List;

import example.apiuseexample.models.DatosOcio;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MadridService {

    @GET("catalogo/206974-0-agenda-eventos-culturales-100.json")
        //Call<List<Repo>> listRepos(@Path("user") String user);
    Call<String> listOcio();
}
