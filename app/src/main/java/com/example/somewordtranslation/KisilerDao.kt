package com.example.somewordtranslation

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {

           @GET("sozluk/tum_kelimeler.php")
           fun allword():Call<KelimelerCavab>

           @POST("sozluk/kelime_ara.php")
           @FormUrlEncoded
           fun searchword(@Field("ingilizce") ingilsce:String):Call<KelimelerCavab>
}