package com.jgt.autotext.ui.fragments.edit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jgt.autotext.R;
import com.jgt.autotext.database.item.Item;
import com.jgt.autotext.ui.activities.main.MainActivityView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditFragmentView extends Fragment implements IEditFragmentContract.View, View.OnClickListener {
    private static final String TAG = EditFragmentView.class.getSimpleName();
    private IEditFragmentContract.Presenter presenter;

    private MainActivityView activity;

    private View rootView;
    private EditText etName, etNumber, etMessage;
    private Button btnAdd, btnDeleteAll;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_edit, container, false);
        setPresenter(new EditFragmentPresenter(this));
        presenter.onCreate();
        return rootView;
    }

    @Override
    public void setPresenter(Object o) {
        this.presenter = (IEditFragmentContract.Presenter) o;
    }

    @Override
    public void initViews() {
        activity = (MainActivityView) getActivity();

        etName = rootView.findViewById(R.id.fragment_edit_et_item_name);
        etNumber = rootView.findViewById(R.id.fragment_edit_et_item_number);
        etMessage = rootView.findViewById(R.id.fragment_edit_et_item_message);
        btnAdd = rootView.findViewById(R.id.fragment_edit_btn_add);
        btnDeleteAll = rootView.findViewById(R.id.fragment_edit_btn_delete_all);

        btnAdd.setOnClickListener(this);
        btnDeleteAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fragment_edit_btn_add:
                String name = etName.getText().toString();
                String number = etNumber.getText().toString();
                String message = etMessage.getText().toString();
                Item item = new Item(name, number, message);
                presenter.onAddClicked(item);
                break;
            case R.id.fragment_edit_btn_delete_all:
                presenter.onDeleteAllClicked();
                break;
            default:
                break;
        }
    }

    @Override
    public void showInsertSuccessToast() {
        Toast.makeText(activity, getResources().getString(R.string.fragment_edit_toast_insert_success),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDeleteAllSuccessToast() {
        Toast.makeText(activity, getResources().getString(R.string.fragment_edit_toast_delete_all_success),
                Toast.LENGTH_LONG).show();
    }
}
