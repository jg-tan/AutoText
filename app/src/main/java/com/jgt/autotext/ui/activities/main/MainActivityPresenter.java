package com.jgt.autotext.ui.activities.main;

public class MainActivityPresenter implements IMainActivityContract.Presenter {
    private static final String TAG = MainActivityPresenter.class.getSimpleName();
    private IMainActivityContract.Model model;
    private IMainActivityContract.View view;

    public MainActivityPresenter(IMainActivityContract.View view) {
        this.view = view;
        setModel(new MainActivityModel(this));
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
        this.model = (IMainActivityContract.Model) o;
    }
}
