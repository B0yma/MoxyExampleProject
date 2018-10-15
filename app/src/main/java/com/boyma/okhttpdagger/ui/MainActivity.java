package com.boyma.okhttpdagger.ui;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.boyma.okhttpdagger.R;

public class MainActivity extends MvpAppCompatActivity implements IMainActivityView {

    private TextView tv;

    @InjectPresenter
    MainActivityPresenter mpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        mpresenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initUI() {
        tv = findViewById(R.id.tv);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setText(String s) {
        tv.setText(s);
    }
}
