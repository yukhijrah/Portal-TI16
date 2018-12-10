package com.example.wahab.portalti16.Network;

import com.example.wahab.portalti16.Entity.DaftarMahasiswa;
import com.example.wahab.portalti16.Entity.Mahasiswa;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by wahab on 10/12/18.
 */

public interface Router {
    @GET("list_mahasiswa")
    Call<DaftarMahasiswa> getMahasiswa();

    @POST("post_mahasiswa")
    @FormUrlEncoded
    Call<Mahasiswa> postMahasiswa(
            @Field("name") String name,
            @Field("nim") String nim
    );
}

