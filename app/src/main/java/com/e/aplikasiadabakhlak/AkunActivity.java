package com.e.aplikasiadabakhlak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.e.aplikasiadabakhlak.Adapter.asprakAdapter;
import com.e.aplikasiadabakhlak.Adapter.dosenAdapter;
import com.e.aplikasiadabakhlak.Adapter.userAdapter;
import com.e.aplikasiadabakhlak.conf.DatabaseHelper;
import com.e.aplikasiadabakhlak.model.user;

import java.util.ArrayList;
import java.util.List;

public class AkunActivity extends AppCompatActivity {
    private RecyclerView recyclerKelompok, recyclerDosen, recyclerAslab;
    private DatabaseHelper db = new DatabaseHelper(this);
    private userAdapter adapterUser;
    private dosenAdapter adapterDosen;
    private asprakAdapter adapterAslab;
    private List<user> userArrayList = new ArrayList<>();
    private List<user> dosenArrayList = new ArrayList<>();
    private List<user> aslabArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        userArrayList = db.readDeveloper();
        recyclerKelompok = (RecyclerView) findViewById(R.id.recycler_kelompok);
        adapterUser = new userAdapter(userArrayList);

        dosenArrayList = db.readDosen();
        recyclerDosen = (RecyclerView) findViewById(R.id.recycler_dosen);
        adapterDosen = new dosenAdapter(dosenArrayList);

        aslabArrayList = db.readAsprak();
        recyclerAslab = (RecyclerView) findViewById(R.id.recycler_aslab);
        adapterAslab = new asprakAdapter(aslabArrayList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(AkunActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerKelompok.setLayoutManager(layoutManager);
        recyclerKelompok.setAdapter(adapterUser);
        recyclerKelompok.setNestedScrollingEnabled(false);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(AkunActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerDosen.setLayoutManager(layoutManager2);
        recyclerDosen.setAdapter(adapterDosen);
        recyclerDosen.setNestedScrollingEnabled(false);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(AkunActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerAslab.setLayoutManager(layoutManager3);
        recyclerAslab.setAdapter(adapterAslab);
        recyclerAslab.setNestedScrollingEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.masuk){
            int status = 1;
            if (status == 1){
                Intent intent = new Intent(AkunActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }else{
                Intent intent = new Intent(AkunActivity.this, TampilActivity.class);
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
