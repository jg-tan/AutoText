package com.jgt.autotext.ui.fragments.list;

import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.ui.IBaseContract;

import java.util.List;

public interface IListFragmentContract {
    interface Model extends IBaseContract.Model {
        List<Item> getItemList();

        void populateItemList();

        void deleteItem(int position);
    }

    interface View extends IBaseContract.View {
        void showList();

        void showItemDeletedSuccess();
    }

    interface Presenter extends IBaseContract.Presenter {
        List<Item> getItemList();

        void onItemListObtained();

        void onItemDeleteClicked(int position);

        void onItemDeleted();

        void onItemLongPressed(int position);
    }
}
