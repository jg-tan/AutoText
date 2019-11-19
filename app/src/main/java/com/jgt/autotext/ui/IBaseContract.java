package com.jgt.autotext.ui;

public interface IBaseContract {
    interface Model<T> {
    }

    interface View<T> {
        void setPresenter(T t);

        void initViews();
    }

    interface Presenter<T> {
        void onCreate();

        void onResume();

        void onDestroy();

        void setModel(T t);
    }
}
