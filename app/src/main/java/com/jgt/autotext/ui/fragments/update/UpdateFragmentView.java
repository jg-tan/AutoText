package com.jgt.autotext.ui.fragments.update;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jgt.autotext.R;
import com.jgt.autotext.ui.activities.main.MainActivityView;
import com.jgt.autotext.utils.Constants;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UpdateFragmentView extends Fragment implements IUpdateFragmentContract.View, View.OnClickListener {
    private static final String TAG = UpdateFragmentView.class.getSimpleName();
    private IUpdateFragmentContract.Presenter presenter;

    private MainActivityView activity;
    private View rootView;
    private EditText etName, etNumber, etMessage;
    private Button btnUpdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_add, container, false);
        setPresenter(new UpdateFragmentPresenter(this));
        presenter.onCreate();
        return rootView;
    }

    @Override
    public void setPresenter(Object o) {
        this.presenter = (IUpdateFragmentContract.Presenter) o;
    }

    @Override
    public void initViews() {
        activity = (MainActivityView) getActivity();

        etName = rootView.findViewById(R.id.fragment_update_et_item_name);
        etNumber = rootView.findViewById(R.id.fragment_add_et_item_number);
        etMessage = rootView.findViewById(R.id.fragment_add_et_item_message);
        btnUpdate = rootView.findViewById(R.id.fragment_add_btn_add);

        etName.setText(getArguments().getString(Constants.FRAGMENT_UPDATE_ITEM_NAME));
        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fragment_add_btn_add:
                String name = getArguments().getString(Constants.FRAGMENT_UPDATE_ITEM_NAME);
                String number = etNumber.getText().toString();
                String message = etMessage.getText().toString();
                presenter.onUpdateClicked(name, number, message);
                break;
            default:
                break;
        }
    }

    @Override
    public void showNumberEmptyToast() {
        Toast.makeText(activity, getResources().getString(R.string.fragment_add_toast_number_empty),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessageEmptyToast() {
        Toast.makeText(activity, getResources().getString(R.string.fragment_add_toast_message_empty),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void dismissKeyboard() {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if(null == view) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void showUpdateItemSuccessToast() {
        Toast.makeText(activity, getResources().getString(R.string.fragment_add_toast_message_empty),
                Toast.LENGTH_LONG).show();
    }
}
