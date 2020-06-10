package com.e.aplikasiadabakhlak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class EditActivity extends AppCompatActivity {
    public static final String EXT_ID = "ID";
    public static final String EXT_JENIS = "EDIT_JENIS";
    public static final String EXT_JUDUL = "EDIT_JUDUL";
    public static final String EXT_MATERI = "EDIT_MATERI";

    private EditText mJenis, mJudul, mMateri;
    private Button btnEdit;
    private APIInterface apiInterface;
    private String id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mJenis = findViewById(R.id.edit_jenis);
        mJudul = findViewById(R.id.edit_judul);
        mMateri = findViewById(R.id.edit_materi);

        mJenis.setText(getIntent().getStringExtra(EXT_JENIS));
        mJudul.setText(getIntent().getStringExtra(EXT_JUDUL));
        mMateri.setText(getIntent().getStringExtra(EXT_MATERI));
        id = getIntent().getStringExtra(EXT_ID);

        Button edit = findViewById(R.id.btn_edit);
        Button hapus = findViewById(R.id.btn_hapus);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editData();

            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusData();
            }
        });

    }

    private void hapusData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIclient.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        APIInterface api = retrofit.create(APIInterface.class);
        Call<String> call = api.hapusAdabAkhlak(id);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(">>>>", response.body().toString());
                if (response.isSuccessful()) {
                    Intent intent = new Intent(EditActivity.this, TampilActivity.class);
                    finish();
                    startActivity(intent);
                } else {
                    Toast.makeText(EditActivity.this, "GAGAL HAPUS", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(EditActivity.this, "GAGAL HAPUS", Toast.LENGTH_LONG).show();

            }
        });
    }
    private void editData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIclient.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        String judul = mJenis.getText().toString();
        String penjelasan = mJudul.getText().toString();
        String referensi = mMateri.getText().toString();

        APIInterface api = retrofit.create(APIInterface.class);
        Call<String> call = api.editAdabAkhlak(judul, penjelasan, referensi, id);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(EditActivity.this, TampilActivity.class);
                    finish();
                    startActivity(intent);
                } else {
                    Toast.makeText(EditActivity.this, "GAGAL EDIT ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(EditActivity.this, "GAGAL EDIT ", Toast.LENGTH_LONG).show();
            }
        });

    }
}
