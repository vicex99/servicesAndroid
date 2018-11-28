package com.utad.tarea_database_fortiniteservice.services.fortiniteTracker

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import com.utad.tarea_database_fortiniteservice.models.ForniteUsers
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface ForniteApi {

    //GET - stats - p10 - score/matches/kills/kpg
    @Headers("TRN-Api-Key: e0e540a5-652d-401b-8214-148a0a342000")
    @GET("profile/{platform}/{epic-nickname}")
    fun loadData(@Path("plataform") plataform: String, @Path("epic-nickname") nickname: String): Observable<List<ForniteUsers>>

    companion object Factory{
        fun start(): ForniteApi {
            val gsonBuilder = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/v1")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                .build()
            return retrofit.create<ForniteApi>(ForniteApi::class.java)
        }
    }

}