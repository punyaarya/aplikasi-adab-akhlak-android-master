package com.e.aplikasiadabakhlak;

import com.e.aplikasiadabakhlak.model.AdabAkhlak;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> getUserLogin(
            @Field("username") String uname,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("insert.php")
    Call<String> insertAdabAkhlak(
            @Field("jenis") String jenis,
            @Field("judul") String judul,
            @Field("materi") String materi);

    @GET("getdata.php")
    Call<AdabAkhlak> getAdabAkhlak();

    @GET("update.php")
    Call<String> editAdabAkhlak(
            @Query("jenis") String jenis,
            @Query("judul") String judul,
            @Query("materi") String materi,
            @Query("id") String id);

    @GET("delete.php")
    Call<String> hapusAdabAkhlak(
            @Query("id") String id);
}
