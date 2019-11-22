package com.jgt.autotext.ui.fragments.edit;

import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.ui.IBaseContract;

public interface IEditFragmentContract {
    interface Model extends IBaseContract.Model {
        void insertItem(Item item);

        void deleteAll();

        //Temporary
        void setSmsEnabled();

        void setSmsDisabled();
        //Temporary
    }

    interface View extends IBaseContract.View {
        void showInsertSuccessToast();

        void showDeleteAllSuccessToast();

        void showNameEmptyToast();

        void showNumberEmptyToast();

        void showMessageEmptyToast();

        void dismissKeyboard();
    }

    interface Presenter extends IBaseContract.Presenter {
        void onAddClicked(String name, String number, String message);

        void onDeleteAllClicked();

        void onInsertSuccess();

        void onDeleteAllSuccess();

        //Temporary
        void onDisableClicked();

        void onEnableClicked();
        //Temporary
    }
}
