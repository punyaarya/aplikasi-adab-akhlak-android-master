package com.e.aplikasiadabakhlak;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.e.aplikasiadabakhlak.model.AdabAkhlak;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView tampil;
    private APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tampil = findViewById(R.id.tampilDoa);
        apiInterface = APIclient.getApiClient().create(APIInterface.class);

        getAdabAkhlak();
    }

    public void getAdabAkhlak(){
        Call<AdabAkhlak> call = apiInterface.getAdabAkhlak();

        call.enqueue(new Callback<AdabAkhlak>() {
            @Override
            public void onResponse(Call<AdabAkhlak> call, Response<AdabAkhlak> response) {
                if (response.isSuccessful()){
                    List<AdabAkhlak.AdabAkhlakList> list = response.body().getAdabAkhlak();
                    AdapterAdabAkhlak adapter = new AdapterAdabAkhlak(list, MainActivity.this);
                    tampil.setAdapter(adapter);
                    tampil.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    tampil.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<AdabAkhlak> call, Throwable t) {
                Log.d("????????????????????", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.akun:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,AkunActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
