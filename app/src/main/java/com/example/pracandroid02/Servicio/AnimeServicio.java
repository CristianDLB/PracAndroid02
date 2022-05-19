package com.example.pracandroid02.Servicio;

import com.example.pracandroid02.Entidades.Animes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeServicio {

   @GET("/v3/480bdd95-8c60-4e23-9f8a-ff76abe98f07")
   Call<List<Animes>> GetAnimes();




}
