package com.jgt.autotext.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jgt.autotext.R;
import com.jgt.autotext.database.item.Item;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemGridAdapter extends RecyclerView.Adapter<ItemGridAdapter.ItemGridViewHolder> {
    private static final String TAG = ItemGridAdapter.class.getSimpleName();

    List<Item> itemList;

    @NonNull
    @Override
    public ItemGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new ItemGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemGridViewHolder holder, int position) {
        if(null != holder) {
            holder.tvName.setText(itemList.get(position).getItemName());
//            holder.ivImage.setImageBitmap();
        }
    }

    @Override
    public int getItemCount() {
        if(null != itemList) {
            return itemList.size();
        }
        return 0;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    class ItemGridViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView ivImage;

        public ItemGridViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.fragment_grid_tv_item_name);
            ivImage = itemView.findViewById(R.id.fragment_grid_iv_item_image);
        }
    }
}
