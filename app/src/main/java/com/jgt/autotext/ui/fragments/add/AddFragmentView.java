package com.jgt.autotext.ui.fragments.add;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddFragmentView extends Fragment implements IAddFragmentContract.View, View.OnClickListener {
    private static final String TAG = AddFragmentView.class.getSimpleName();
    private IAddFragmentContract.Presenter presenter;

    private MainActivityView activity;
    private View rootView;
    private EditText etName, etNumber, etMessage;
    private Button btnAdd, btnDeleteAll;
    //Temporary
    private Button btnEnable, btnDisable;
    //Temporary

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_add, container, false);
        setPresenter(new AddFragmentPresenter(this));
        presenter.onCreate();
        return rootView;
    }

    @Override
    public void setPresenter(Object o) {
        this.presenter = (IAddFragmentContract.Presenter) o;
    }

    @Override
    public void initViews() {
        activity = (MainActivityView) getActivity();

        etName = rootView.findViewById(R.id.fragment_add_et_item_name);
        etNumber = rootView.findViewById(R.id.fragment_add_et_item_number);
        etMessage = rootView.findViewById(R.id.fragment_add_et_item_message);
        btnAdd = rootView.findViewById(R.id.fragment_add_btn_add);
        btnDeleteAll = rootView.findViewById(R.id.fragment_add_btn_delete_all);

        btnEnable = rootView.findViewById(R.id.fragment_add_btn_enable_sms);
        btnDisable = rootView.findViewById(R.id.fragment_add_btn_disable_sms);

        btnAdd.setOnClickListener(this);
        btnDeleteAll.setOnClickListener(this);

        btnEnable.setOnClickListener(this);
        btnDisable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fragment_add_btn_add:
                String name = etName.getText().toString();
                String number = etNumber.getText().toString();
                String message = etMessage.getText().toString();
                presenter.onAddClicked(name, number, message);
                break;
            case R.id.fragment_add_btn_delete_all:
                presenter.onDeleteAllClicked();
                break;
            //Temporary
            case R.id.fragment_add_btn_enable_sms:
                presenter.onEnableClicked();
                break;
            case R.id.fragment_add_btn_disable_sms:
                presenter.onDisableClicked();
                break;
            //Temporary
            default:
                break;
        }
    }

    @Override
    public void showInsertSuccessToast() {
        Toast.makeText(activity, getResources().getString(R.string.fragment_add_toast_insert_success),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDeleteAllSuccessToast() {
        Toast.makeText(activity, getResources().getString(R.string.fragment_add_toast_delete_all_success),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNameEmptyToast() {
        Toast.makeText(activity, getResources().getString(R.string.fragment_add_toast_name_empty),
                Toast.LENGTH_LONG).show();
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
}
