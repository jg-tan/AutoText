package com.jgt.autotext.ui.fragments.list;

import com.jgt.autotext.database.DatabaseTaskListener;
import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.database.item.ItemRepository;

import java.util.List;

public class ListFragmentModel implements IListFragmentContract.Model, DatabaseTaskListener {
    private static final String TAG = ListFragmentModel.class.getSimpleName();
    private IListFragmentContract.Presenter presenter;
    private ItemRepository itemRepository;
    private List<Item> itemList;

    public ListFragmentModel(IListFragmentContract.Presenter presenter) {
        this.presenter = presenter;
        itemRepository = ItemRepository.getInstance();
    }

    @Override
    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public void populateItemList() {
        itemRepository.populateItemList(this);
    }

    @Override
    public void onFinish() {
        itemList = itemRepository.getItemList();
        presenter.onItemListObtained();
    }
}
