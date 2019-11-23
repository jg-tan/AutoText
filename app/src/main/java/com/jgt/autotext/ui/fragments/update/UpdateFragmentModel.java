package com.jgt.autotext.ui.fragments.update;

import com.jgt.autotext.database.DatabaseTaskListener;
import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.database.item.ItemRepository;
import com.jgt.autotext.utils.Constants;
import com.jgt.autotext.utils.SharedPref;

public class UpdateFragmentModel implements IUpdateFragmentContract.Model, DatabaseTaskListener {
    private static final String TAG = UpdateFragmentModel.class.getSimpleName();
    private IUpdateFragmentContract.Presenter presenter;
    private ItemRepository itemRepository;

    private String TASK = "";

    public UpdateFragmentModel(IUpdateFragmentContract.Presenter presenter) {
        this.presenter = presenter;
        itemRepository = ItemRepository.getInstance();
    }

    @Override
    public void onFinish() {
        switch (TASK) {
            case Constants.TASK_UPDATE_ITEM:
                presenter.onUpdateSuccess();
                break;
            default:
                break;
        }
    }

    @Override
    public void updateItem(Item item) {
        TASK = Constants.TASK_UPDATE_ITEM;
        itemRepository.updateItem(item, this);
    }
}
