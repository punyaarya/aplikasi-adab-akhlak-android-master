package com.e.aplikasiadabakhlak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TambahActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        final EditText jenis = findViewById(R.id.insert_jenis);
        final EditText judul = findViewById(R.id.insert_judul);
        final EditText materi = findViewById(R.id.insert_materi);
        Button insert = findViewById(R.id.btn_simpan);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(jenis.getText().toString().trim(), judul.getText().toString().trim(), materi.getText().toString().trim());
            }
        });
    }

    private void insert(String jenis, String judul, String materi) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIclient.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        APIInterface api = retrofit.create(APIInterface.class);

        Call<String> call = api.insertAdabAkhlak(jenis, judul, materi);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject object = new JSONObject(response.body().toString());
                        if (object.getString("query_result").equals("SUCCESS")) {
                            Intent intent = new Intent(TambahActivity.this, TampilActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(TambahActivity.this, "Tidak Biasa", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(TambahActivity.this, "Internet Tidak Nyambung", Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(">>>>>", t.getLocalizedMessage());
            }
        });
    }
}
