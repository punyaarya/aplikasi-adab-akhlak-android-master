package com.e.aplikasiadabakhlak;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.aplikasiadabakhlak.model.AdabAkhlak;

import java.util.List;

public class AdapterAdabAkhlak extends RecyclerView.Adapter<AdapterAdabAkhlak.MyViewHolder > {

private List<AdabAkhlak.AdabAkhlakList> adabakhlak;
private Context context;

    public AdapterAdabAkhlak(List<com.e.aplikasiadabakhlak.model.AdabAkhlak.AdabAkhlakList> adabakhlak, Context context) {
        this.adabakhlak = adabakhlak;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterAdabAkhlak.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_sholat, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAdabAkhlak.MyViewHolder myViewHolder, final int i) {
        myViewHolder.judul.setText(adabakhlak.get(i).getJudul());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AdabAkhlakActivity.class);
                intent.putExtra(AdabAkhlakActivity.EXT_ID, adabakhlak.get(i).getId());
                intent.putExtra(AdabAkhlakActivity.EXT_JENIS, adabakhlak.get(i).getJenis());
                intent.putExtra(AdabAkhlakActivity.EXT_JUDUL, adabakhlak.get(i).getJudul());
                intent.putExtra(AdabAkhlakActivity.EXT_MATERI, adabakhlak.get(i).getMateri());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return adabakhlak.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView judul;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul);

        }
    }
}
