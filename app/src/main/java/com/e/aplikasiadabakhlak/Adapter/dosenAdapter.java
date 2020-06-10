package com.e.aplikasiadabakhlak.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.aplikasiadabakhlak.R;
import com.e.aplikasiadabakhlak.model.user;

import java.util.List;

public class dosenAdapter extends RecyclerView.Adapter<dosenAdapter.UserViewHolder> {
    private List<user> dataList;

    public dosenAdapter(List<user> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.tvNama.setText(dataList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = (TextView)itemView.findViewById(R.id.nm_user);
        }
    }
}
