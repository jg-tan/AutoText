package com.jgt.autotext.ui.fragments.grid;

import com.jgt.autotext.database.DatabaseTaskListener;
import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.database.item.ItemRepository;

import java.util.List;

public class GridFragmentModel implements IGridFragmentContract.Model, DatabaseTaskListener {
    private static final String TAG = GridFragmentModel.class.getSimpleName();
    private IGridFragmentContract.Presenter presenter;
    private ItemRepository itemRepository;
    private List<Item> itemList;

    public GridFragmentModel(IGridFragmentContract.Presenter presenter) {
        this.presenter = presenter;
        itemRepository = ItemRepository.getInstance();
    }

    @Override
    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public void populateItemGrid() {
        itemRepository.populateItemList(this);
    }

    @Override
    public void onFinish() {
        itemList = itemRepository.getItemList();
        presenter.onItemListObtained();
    }
}
