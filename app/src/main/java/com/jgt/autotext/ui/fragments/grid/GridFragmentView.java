package com.jgt.autotext.ui.fragments.grid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jgt.autotext.R;
import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.ui.activities.main.MainActivityView;
import com.jgt.autotext.ui.adapters.ItemGridAdapter;
import com.jgt.autotext.utils.Log;
import com.jgt.autotext.utils.Utils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridFragmentView extends Fragment implements IGridFragmentContract.View {
    private static final String TAG = GridFragmentView.class.getSimpleName();
    private IGridFragmentContract.Presenter presenter;

    private MainActivityView activity;
    private View rootView;
    private ItemGridAdapter adapter;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView rvItemGrid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_grid, container, false);
        setPresenter(new GridFragmentPresenter(this));
        presenter.onCreate();
        return rootView;
    }

    @Override
    public void setPresenter(Object o) {
        this.presenter = (IGridFragmentContract.Presenter) o;
    }

    @Override
    public void initViews() {
        activity = (MainActivityView) getActivity();

        rvItemGrid = rootView.findViewById(R.id.fragment_grid_rv_item_grid);
        adapter = new ItemGridAdapter();

        rvItemGrid.setHasFixedSize(true);
        rvItemGrid.setAdapter(adapter);
    }

    @Override
    public void showGrid() {
        List<Item> itemList = presenter.getItemList();

        if(itemList.isEmpty()) {
            return;
        }

        Log.d(TAG, "" + itemList.size() + " " + Utils.getRowColCount(itemList.size()));
        gridLayoutManager = new GridLayoutManager(activity, Utils.getRowColCount(itemList.size()));
        rvItemGrid.setLayoutManager(gridLayoutManager);
        adapter.setItemList(itemList);
    }
}
