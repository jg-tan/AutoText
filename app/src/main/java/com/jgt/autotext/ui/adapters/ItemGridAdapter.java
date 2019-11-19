package com.jgt.autotext.ui.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemGridAdapter extends RecyclerView.Adapter<ItemGridAdapter.ItemGridViewHolder> {
    private static final String TAG = ItemGridAdapter.class.getSimpleName();

    @NonNull
    @Override
    public ItemGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemGridViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemGridViewHolder extends RecyclerView.ViewHolder {
        public ItemGridViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
