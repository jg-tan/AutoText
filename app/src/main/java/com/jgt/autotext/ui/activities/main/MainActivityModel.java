package com.jgt.autotext.ui.activities.main;

public class MainActivityModel implements IMainActivityContract.Model {
    private static final String TAG = MainActivityModel.class.getSimpleName();
    private IMainActivityContract.Presenter presenter;

    public MainActivityModel(IMainActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
