package com.jgt.autotext.ui.fragments.list;

import com.jgt.autotext.database.DatabaseTaskListener;
import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.database.item.ItemRepository;
import com.jgt.autotext.utils.Constants;

import java.util.List;

public class ListFragmentModel implements IListFragmentContract.Model, DatabaseTaskListener {
    private static final String TAG = ListFragmentModel.class.getSimpleName();
    private IListFragmentContract.Presenter presenter;
    private ItemRepository itemRepository;
    private List<Item> itemList;
    private String TASK = "";

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
        TASK = Constants.TASK_QUERY_ALL;
        itemRepository.populateItemList(this);
    }

    @Override
    public void deleteItem(int position) {
        TASK = Constants.TASK_DELETE;
        String itemName = itemList.get(position).getItemName();
        itemRepository.deleteItem(itemName, this);
    }

    @Override
    public void onFinish() {
        switch (TASK) {
            case Constants.TASK_QUERY_ALL:
                itemList = itemRepository.getItemList();
                presenter.onItemListObtained();
                break;
            case Constants.TASK_DELETE:
                presenter.onItemDeleted();
                break;
            default:
                break;
        }
    }
}
