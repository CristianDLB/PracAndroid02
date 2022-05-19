package com.example.pracandroid02.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pracandroid02.Entidades.Animes;
import com.example.pracandroid02.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeHolder> {

    List<Animes> animes ;
    public AnimeAdapter(List<Animes> animes){
        this.animes = animes;
    }


    @NonNull
    @Override
    public AnimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animes, parent,false);
        AnimeHolder h = new AnimeHolder(vista);

        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeHolder holder, int position) {
        Animes an = animes.get(position);
        TextView TvTitulo = holder.itemView.findViewById(R.id.tituloA);
        TextView TvDescripcion = holder.itemView.findViewById(R.id.descriA);

        TvTitulo.setText(an.nombre);
        TvDescripcion.setText(an.descripcion);

        ImageView imagen = holder.itemView.findViewById(R.id.imgPiscaso);
        Picasso.get()
                .load("https://i.imgur.com/vlJyZiz.jpeg")
                .into(imagen);

        /*
            Img Komi: https://i.imgur.com/vlJyZiz.jpeg
            Img Tomodachi: https://i.imgur.com/GDpoHuU.jpeg
            Img Tate no Yuusha: https://i.imgur.com/dnfYogx.jpeg
            Img Shijou Saikyou no: https://i.imgur.com/TXJuOLC.jpeg
            Img Kaginado: https://i.imgur.com/uDyy0ot.jpeg
        */


    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    class AnimeHolder extends  RecyclerView.ViewHolder{

        public AnimeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
