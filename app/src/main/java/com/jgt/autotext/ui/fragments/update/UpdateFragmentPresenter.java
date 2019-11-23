package com.jgt.autotext.ui.fragments.update;

import com.jgt.autotext.database.item.Item;

public class UpdateFragmentPresenter implements IUpdateFragmentContract.Presenter {
    private static final String TAG = UpdateFragmentPresenter.class.getSimpleName();
    private IUpdateFragmentContract.Model model;
    private IUpdateFragmentContract.View view;

    public UpdateFragmentPresenter(IUpdateFragmentContract.View view) {
        this.view = view;
        setModel(new UpdateFragmentModel(this));
    }

    @Override
    public void onCreate() {
        view.initViews();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void setModel(Object o) {
        this.model = (IUpdateFragmentContract.Model) o;
    }

    @Override
    public void onUpdateClicked(String name, String number, String message) {
        if(number.isEmpty()) {
            view.showNumberEmptyToast();
            return;
        }

        if(message.isEmpty()) {
            view.showMessageEmptyToast();
            return;
        }

        Item item = new Item(name, number, message);
        model.updateItem(item);
        view.dismissKeyboard();
    }

    @Override
    public void onUpdateSuccess() {
        view.showUpdateItemSuccessToast();
    }
}
