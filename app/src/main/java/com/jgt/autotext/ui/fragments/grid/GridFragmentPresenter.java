package com.jgt.autotext.ui.fragments.grid;

import com.jgt.autotext.database.item.Item;

import java.util.List;

public class GridFragmentPresenter implements IGridFragmentContract.Presenter {
    private static final String TAG = GridFragmentPresenter.class.getSimpleName();
    private IGridFragmentContract.Model model;
    private IGridFragmentContract.View view;

    public GridFragmentPresenter(IGridFragmentContract.View view) {
        this.view = view;
        setModel(new GridFragmentModel(this));
    }
    @Override
    public void onCreate() {
        view.initViews();
        model.populateItemGrid();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void setModel(Object o) {
        this.model = (IGridFragmentContract.Model) o;
    }

    @Override
    public void onItemListObtained() {
        view.showGrid();
    }

    @Override
    public List<Item> getItemList() {
        return model.getItemList();
    }
}
