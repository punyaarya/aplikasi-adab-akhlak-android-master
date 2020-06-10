package com.e.aplikasiadabakhlak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.e.aplikasiadabakhlak.model.AdabAkhlak;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilActivity extends AppCompatActivity {
    private RecyclerView tampil;
    private Button btn_tambah;
    private APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_tampil);

tampil = findViewById(R.id.mbohopo);
        apiInterface = APIclient.getApiClient().create(APIInterface.class);
        btn_tambah = findViewById(R.id.btn_tambah);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TampilActivity.this, TambahActivity.class);
                startActivity(intent);
                finish();
            }
        });
        getAdabAkhlak();
    }
    public void getAdabAkhlak() {
        Call<AdabAkhlak> call = apiInterface.getAdabAkhlak();

            call.enqueue(new Callback<AdabAkhlak>() {
                @Override
                public void onResponse(retrofit2.Call<AdabAkhlak> call, Response<AdabAkhlak> response) {
                    if (response.isSuccessful()) {
                        List<AdabAkhlak.AdabAkhlakList> list = response.body().getAdabAkhlak();
                        AdapterAdabAkhlakAdmin adapter = new AdapterAdabAkhlakAdmin(list, TampilActivity.this);
                        tampil.setAdapter(adapter);
                        tampil.setLayoutManager(new LinearLayoutManager(TampilActivity.this));
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<AdabAkhlak> call, Throwable t) {

                }
            });
        }
    }