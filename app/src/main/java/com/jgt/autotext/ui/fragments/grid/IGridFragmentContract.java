package com.jgt.autotext.ui.fragments.grid;

import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.ui.IBaseContract;

import java.util.List;

public interface IGridFragmentContract {
    interface Model extends IBaseContract.Model {
        void populateItemGrid();

        List<Item> getItemList();
    }

    interface View extends IBaseContract.View {
        void showGrid();
    }

    interface Presenter extends IBaseContract.Presenter {
        void onItemListObtained();

        List<Item> getItemList();
    }
}
