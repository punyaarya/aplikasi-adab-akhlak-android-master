package com.e.aplikasiadabakhlak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AdabAkhlakActivity extends AppCompatActivity {
    public static final String EXT_ID = "ID";
    public static final String EXT_JENIS = "EDIT_JENIS";
    public static final String EXT_JUDUL = "EDIT_JUDUL";
    public static final String EXT_MATERI = "EDIT_MATERI";

    private TextView mJenis, mJudul, mMateri;
    private String id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sholat);

        mJenis = findViewById(R.id.kontenJenis);
        mJudul = findViewById(R.id.kontenJudul);
        mMateri = findViewById(R.id.kontenMateri);

        mJenis.setText(getIntent().getStringExtra(EXT_JENIS));
        mJudul.setText(getIntent().getStringExtra(EXT_JUDUL));
        mMateri.setText(getIntent().getStringExtra(EXT_MATERI));
        id = getIntent().getStringExtra(EXT_ID);
    }
}
