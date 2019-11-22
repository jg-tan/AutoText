package com.jgt.autotext.ui.activities.main;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jgt.autotext.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivityView extends AppCompatActivity implements IMainActivityContract.View  {
    private static final String TAG = MainActivityView.class.getSimpleName();
    private IMainActivityContract.Presenter presenter;
    private Context context;

    private BottomNavigationView bottomNavigationView;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        setPresenter(new MainActivityPresenter(this));
        presenter.onCreate();
    }

    @Override
    public void setPresenter(Object o) {
        this.presenter = (IMainActivityContract.Presenter) o;
    }

    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav_view);
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_grid, R.id.navigation_list, R.id.navigation_edit)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public void requestPermissions() {
        if(PackageManager.PERMISSION_DENIED == checkSelfPermission(Manifest.permission.SEND_SMS)) {
            String[] permissions = {Manifest.permission.SEND_SMS};
            requestPermissions(permissions, 1);
        }
    }
}
