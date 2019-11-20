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
    public void onAddClicked(Item item) {
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

    @Override
    public void onDeleteAllClicked() {
        model.deleteAll();
    }
}
