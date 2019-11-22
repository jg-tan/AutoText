package com.jgt.autotext.ui.activities.main;

import com.jgt.autotext.ui.IBaseContract;

public interface IMainActivityContract {
    interface Model extends IBaseContract.Model {
    }

    interface View extends IBaseContract.View {
        void requestPermissions();
    }

    interface Presenter extends IBaseContract.Presenter {
    }
}
