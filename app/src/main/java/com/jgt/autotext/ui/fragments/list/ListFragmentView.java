package com.jgt.autotext.ui.fragments.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jgt.autotext.R;
import com.jgt.autotext.ui.activities.main.MainActivityView;
import com.jgt.autotext.ui.adapters.ItemListAdapter;
import com.jgt.autotext.utils.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragmentView extends Fragment implements IListFragmentContract.View {
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

        rvItemList.setHasFixedSize(true);
        rvItemList.setLayoutManager(linearLayoutManager);
        rvItemList.setAdapter(adapter);
    }

    @Override
    public void showList() {
        Log.d(TAG, "List Size: " + presenter.getItemList().size());
        adapter.setItemList(presenter.getItemList());
    }
}
