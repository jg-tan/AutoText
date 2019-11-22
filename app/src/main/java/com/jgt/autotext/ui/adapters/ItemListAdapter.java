package com.jgt.autotext.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jgt.autotext.R;
import com.jgt.autotext.database.item.Item;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder> {
    private static final String TAG = ItemListAdapter.class.getSimpleName();

    private List<Item> itemList;
    private View.OnClickListener onClickListener;

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        if(null != holder) {
            holder.tvName.setText(itemList.get(position).getItemName());
            holder.tvNumber.setText(itemList.get(position).getItemNumber());
            holder.tvMessage.setText(itemList.get(position).getItemMessage());
            holder.tvCount.setText(String.valueOf(itemList.get(position).getItemCount()));
            holder.btnDelete.setOnClickListener(onClickListener);
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

    public void setOnClickListener(View.OnClickListener listener) {
        this.onClickListener = listener;
    }

    class ItemListViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvNumber, tvMessage, tvCount;
        public ImageButton btnDelete;

        public ItemListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.fragment_list_tv_name);
            this.tvNumber = itemView.findViewById(R.id.fragment_list_tv_number);
            this.tvMessage = itemView.findViewById(R.id.fragment_list_tv_message);
            this.tvCount = itemView.findViewById(R.id.fragment_list_tv_count);
            this.btnDelete = itemView.findViewById(R.id.fragment_list_btn_delete);
            this.btnDelete.setTag(this);
        }
    }
}
