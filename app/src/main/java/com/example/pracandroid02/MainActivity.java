package com.example.pracandroid02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pracandroid02.Adaptador.AnimeAdapter;
import com.example.pracandroid02.Entidades.Animes;
import com.example.pracandroid02.Servicio.AnimeServicio;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimeServicio serA = retro.create(AnimeServicio.class);
        Call<List<Animes>> call = serA.GetAnimes();

        call.enqueue(new Callback<List<Animes>>() {
            @Override
            public void onResponse(Call<List<Animes>> call, Response<List<Animes>> response) {
                if(!response.isSuccessful()){
                    Log.e("App_Animess","ERROR APP");
                } else {
                    Log.e("App_Animess","Me Conecteeee :)");
                    List<Animes> anime = response.body();
                    AnimeAdapter adaptar = new AnimeAdapter(anime);

                    RecyclerView rv = findViewById(R.id.animeRv);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adaptar);
                }
            }

            @Override
            public void onFailure(Call<List<Animes>> call, Throwable t) {
                Log.e("App_Animess","No Hubo conectividad");
            }
        });




/*
        List<Animes> anime = getAnimes();
        AnimeAdapter adaptar = new AnimeAdapter(anime);

        RecyclerView rv = findViewById(R.id.animeRv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);
        rv.setAdapter(adaptar);
*/

    }
/*
    private List<Animes> getAnimes(){
        List<Animes> anime = new ArrayList<>();
        anime.add(new Animes("Komi-san wa","Descripcion de Komi-san wa","https://i.imgur.com/vlJyZiz.jpeg"));
        anime.add(new Animes("Tomodachi Game","Descripcion de Tomodachi Game","https://i.imgur.com/GDpoHuU.jpeg"));
        anime.add(new Animes("Tate no Yuusha","Descripcion de Tate no Yuusha", "https://i.imgur.com/dnfYogx.jpeg"));
        anime.add(new Animes("Shijou Saikyou no","Descripcion de Shijou Saikyou no","https://i.imgur.com/TXJuOLC.jpeg"));
        anime.add(new Animes("Kaginado ","Descripcion de Kaginado","https://i.imgur.com/uDyy0ot.jpeg"));
        return anime;
    }

*/

}