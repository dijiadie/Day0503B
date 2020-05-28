package com.zql.day0503b;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private LinearLayout contents;
    private Button home;
    private Button add;
    private TextView txt;
    private HomeFragment homeFragment;
    private ShouwFragment shouwFragment;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        contents = (LinearLayout) findViewById(R.id.contents);
        home = (Button) findViewById(R.id.home);
        add = (Button) findViewById(R.id.add);
        setSupportActionBar(toolbar);
        home.setOnClickListener(this);
        add.setOnClickListener(this);
        txt = (TextView) findViewById(R.id.txt);
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        shouwFragment = new ShouwFragment();
        fragmentTransaction.add(R.id.contents, homeFragment)
                .add(R.id.contents, shouwFragment)
                .hide(shouwFragment)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home:
                txt.setText("首页");
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.show(homeFragment).hide(shouwFragment);
                fragmentTransaction.commit();
                break;
            case R.id.add:
                txt.setText("收藏");
                FragmentTransaction fragmentTransaction1 = supportFragmentManager.beginTransaction();
                fragmentTransaction1.show(shouwFragment).hide(homeFragment);
                fragmentTransaction1.commit();
                break;
        }
    }
}
