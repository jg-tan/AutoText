package com.jgt.autotext.ui.fragments.grid;

import com.jgt.autotext.database.DatabaseTaskListener;
import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.database.item.ItemRepository;
import com.jgt.autotext.utils.Constants;

import java.util.List;

public class GridFragmentModel implements IGridFragmentContract.Model, DatabaseTaskListener {
    private static final String TAG = GridFragmentModel.class.getSimpleName();
    private IGridFragmentContract.Presenter presenter;
    private ItemRepository itemRepository;
    private List<Item> itemList;
    private String TASK = "";

    public GridFragmentModel(IGridFragmentContract.Presenter presenter) {
        this.presenter = presenter;
        itemRepository = ItemRepository.getInstance();
    }

    @Override
    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public void increaseCount(int position) {
        TASK = Constants.TASK_ADD_COUNT;
        String itemName = itemList.get(position).getItemName();
        itemRepository.addCount(itemName, this);
    }

    @Override
    public void sendSms(int position) {

    }

    @Override
    public Item getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public void populateItemGrid() {
        TASK = Constants.TASK_QUERY_ALL;
        itemRepository.populateItemList(this);
    }

    @Override
    public void onFinish() {
        switch (TASK) {
            case Constants.TASK_QUERY_ALL:
                itemList = itemRepository.getItemList();
                presenter.onItemListObtained();
                break;
            default:
                break;
        }
    }
}
