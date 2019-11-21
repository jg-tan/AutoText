package com.jgt.autotext.ui.fragments.list;

import com.jgt.autotext.database.item.Item;

import java.util.List;

public class ListFragmentPresenter implements IListFragmentContract.Presenter {
    private static final String TAG = ListFragmentPresenter.class.getSimpleName();
    private IListFragmentContract.Model model;
    private IListFragmentContract.View view;

    public ListFragmentPresenter(IListFragmentContract.View view) {
        this.view = view;
        setModel(new ListFragmentModel(this));
    }

    @Override
    public void onCreate() {
        view.initViews();
        model.populateItemList();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void setModel(Object o) {
        this.model = (IListFragmentContract.Model) o;
    }

    @Override
    public List<Item> getItemList() {
        return model.getItemList();
    }

    @Override
    public void onItemListObtained() {
        view.showList();
    }
}
