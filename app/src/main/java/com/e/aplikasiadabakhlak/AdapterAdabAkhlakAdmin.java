package com.e.aplikasiadabakhlak;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.aplikasiadabakhlak.model.AdabAkhlak;

import java.util.List;

public class AdapterAdabAkhlakAdmin extends RecyclerView.Adapter<AdapterAdabAkhlakAdmin.MyViewHolder> {
    private List<AdabAkhlak.AdabAkhlakList> adabakhlak;
    private Context context;

    public AdapterAdabAkhlakAdmin(List<AdabAkhlak.AdabAkhlakList> adabakhlak, Context context) {
        this.adabakhlak = adabakhlak;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_sholat, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView judul;
//        private TextView ayat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.judul);
//            ayat = itemView.findViewById(R.id.ayat);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.judul.setText(adabakhlak.get(i).getJudul());
//        myViewHolder.ayat.setText(doa.get(i).getAyat());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra(EditActivity.EXT_ID, adabakhlak.get(i).getId());
                intent.putExtra(EditActivity.EXT_JENIS, adabakhlak.get(i).getJenis());
                intent.putExtra(EditActivity.EXT_JUDUL, adabakhlak.get(i).getJudul());
                intent.putExtra(EditActivity.EXT_MATERI, adabakhlak.get(i).getMateri());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return adabakhlak.size();
    }

}
