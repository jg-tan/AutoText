package com.jgt.autotext.ui.fragments.edit;

import com.jgt.autotext.database.item.Item;

public class EditFragmentPresenter implements IEditFragmentContract.Presenter {
    private static final String TAG = EditFragmentPresenter.class.getSimpleName();
    private IEditFragmentContract.Model model;
    private IEditFragmentContract.View view;

    public EditFragmentPresenter(IEditFragmentContract.View view) {
        this.view = view;
        setModel(new EditFragmentModel(this));
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
        this.model = (IEditFragmentContract.Model) o;
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
