package com.jgt.autotext.ui.fragments.edit;

import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.ui.IBaseContract;

public interface IEditFragmentContract {
    interface Model extends IBaseContract.Model {
        void insertItem(Item item);

        void deleteAll();
    }

    interface View extends IBaseContract.View {
        void showInsertSuccessToast();

        void showDeleteAllSuccessToast();
    }

    interface Presenter extends IBaseContract.Presenter {
        void onAddClicked(Item item);

        void onDeleteAllClicked();

        void onInsertSuccess();

        void onDeleteAllSuccess();
    }
}
