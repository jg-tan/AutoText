package com.jgt.autotext.ui.fragments.update;

import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.ui.IBaseContract;

public interface IUpdateFragmentContract {
    interface Model extends IBaseContract.Model {
        void updateItem(Item item);
    }

    interface View extends IBaseContract.View {
        void showNumberEmptyToast();

        void showMessageEmptyToast();

        void dismissKeyboard();

        void showUpdateItemSuccessToast();
    }

    interface Presenter extends IBaseContract.Presenter {
        void onUpdateClicked(String name, String number, String message);

        void onUpdateSuccess();
    }
}
