package example.apiuseexample;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import example.apiuseexample.models.DatosOcio;
import example.apiuseexample.rest.MadridService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {

    private TextView showOutData;
    private Retrofit retrofit;
    private TaskStackBuilder gsonConverterFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apioutput);


        TextView showOutData = findViewById(R.id.textView);
        //showOutData.setText("Hola");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://datos.madrid.es/egob/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MadridService service = retrofit.create(MadridService.class);

        service.listOcio()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        x -> {
                            for(DatosOcio actividadOcio: x) {
                                Log.e("Id actividad de Ocio:", actividadOcio.getName());
                                ((TextView)findViewById(R.id.textView)).setText(actividadOcio.getId());
                            }
                        }
                );

    }
}