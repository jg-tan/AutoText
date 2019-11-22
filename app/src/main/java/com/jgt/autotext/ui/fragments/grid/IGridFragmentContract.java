package com.jgt.autotext.ui.fragments.grid;

import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.ui.IBaseContract;

import java.util.List;

public interface IGridFragmentContract {
    interface Model extends IBaseContract.Model {
        void populateItemGrid();

        List<Item> getItemList();

        void increaseCount(int position);

        void sendSms(int position);

        Item getItem(int position);
    }

    interface View extends IBaseContract.View {
        void showGrid();

        void sendSms(String number, String message);
    }

    interface Presenter extends IBaseContract.Presenter {
        void onItemListObtained();

        List<Item> getItemList();

        void onItemClicked(int position);
    }
}
