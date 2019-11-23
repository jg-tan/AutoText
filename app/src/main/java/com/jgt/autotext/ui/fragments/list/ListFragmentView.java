package com.jgt.autotext.ui.fragments.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jgt.autotext.R;
import com.jgt.autotext.ui.activities.main.MainActivityView;
import com.jgt.autotext.ui.adapters.ItemListAdapter;
import com.jgt.autotext.utils.Constants;
import com.jgt.autotext.utils.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragmentView extends Fragment implements IListFragmentContract.View, View.OnClickListener, View.OnLongClickListener {
    private static final String TAG = ListFragmentView.class.getSimpleName();
    private IListFragmentContract.Presenter presenter;

    private MainActivityView activity;
    private View rootView;
    private ItemListAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView rvItemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        setPresenter(new ListFragmentPresenter(this));
        presenter.onCreate();
        return rootView;
    }

    @Override
    public void setPresenter(Object o) {
        this.presenter = (IListFragmentContract.Presenter) o;
    }

    @Override
    public void initViews() {
        activity = (MainActivityView) getActivity();

        rvItemList = rootView.findViewById(R.id.fragment_list_rv_item_list);
        adapter = new ItemListAdapter();
        linearLayoutManager = new LinearLayoutManager(activity);

        adapter.setOnClickListener(this);
        adapter.setOnLongClickListener(this);
        rvItemList.setHasFixedSize(true);
        rvItemList.setLayoutManager(linearLayoutManager);
        rvItemList.setAdapter(adapter);
    }

    @Override
    public void showList() {
        Log.d(TAG, "List Size: " + presenter.getItemList().size());
        adapter.setItemList(presenter.getItemList());
    }

    @Override
    public void showItemDeletedSuccess() {
        Toast.makeText(activity, getResources().getString(R.string.fragment_list_toast_item_delete_success),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if (!(v.getTag() instanceof RecyclerView.ViewHolder)) {
            return;
        }

        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
        int position = viewHolder.getAdapterPosition();
        int id = v.getId();
        Log.d(TAG, "" + position);
        switch (id) {
            case R.id.fragment_list_btn_delete:
                presenter.onItemDeleteClicked(position);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (!(v.getTag() instanceof RecyclerView.ViewHolder)) {
            return false;
        }

        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
        int position = viewHolder.getAdapterPosition();
        int id = v.getId();
        switch (id) {
            case R.id.fragment_list_item_container:
                Bundle args = new Bundle();
                args.putString(Constants.FRAGMENT_UPDATE_ITEM_NAME, presenter.getItemList().get(position).getItemName());
                Navigation.findNavController(v).navigate(R.id.fragment_list_action_item_long_press, args);
                break;
            default:
                break;
        }
        return true;
    }
}
