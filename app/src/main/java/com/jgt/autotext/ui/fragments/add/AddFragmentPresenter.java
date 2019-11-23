package com.jgt.autotext.ui.fragments.add;

import com.jgt.autotext.database.item.Item;

public class AddFragmentPresenter implements IAddFragmentContract.Presenter {
    private static final String TAG = AddFragmentPresenter.class.getSimpleName();
    private IAddFragmentContract.Model model;
    private IAddFragmentContract.View view;

    public AddFragmentPresenter(IAddFragmentContract.View view) {
        this.view = view;
        setModel(new AddFragmentModel(this));
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
        this.model = (IAddFragmentContract.Model) o;
    }

    @Override
    public void onAddClicked(String name, String number, String message) {
        if(name.isEmpty()) {
            view.showNameEmptyToast();
            return;
        }

        if(number.isEmpty()) {
            view.showNumberEmptyToast();
            return;
        }

        if(message.isEmpty()) {
            view.showMessageEmptyToast();
            return;
        }

        Item item = new Item(name, number, message);
        model.insertItem(item);
        view.dismissKeyboard();
    }

    @Override
    public void onInsertSuccess() {
        view.showInsertSuccessToast();
    }

    @Override
    public void onDeleteAllSuccess() {
        view.showDeleteAllSuccessToast();
    }

    //Temporary
    @Override
    public void onDisableClicked() {
        model.setSmsDisabled();
    }

    @Override
    public void onEnableClicked() {
        model.setSmsEnabled();
    }
    //Temporary

    @Override
    public void onDeleteAllClicked() {
        model.deleteAll();
    }
}
