package com.jason.viewandanimation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jason.viewandanimation.R;
import com.jason.viewandanimation.view.PercentView;
import com.jason.viewandanimation.view.TitleBarView;

public class ViewActivity extends AppCompatActivity {

    private PercentView mPercentView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_1:
                    mPercentView.invalidate();
                    return true;
                case R.id.navigation_2:
                    return true;
                case R.id.navigation_3:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TitleBarView titleBarView = (TitleBarView) findViewById(R.id.title_bar);
        titleBarView.setAlpha(0.5f);
        titleBarView.getTitleLiftBtn().setText("返回");
        titleBarView.getTitleText().setText("我是自定义View的标题");
        titleBarView.getTitleText().setTextSize(20);
        titleBarView.getTitleRightBtn().setText("分享");
        titleBarView.getTitleLiftBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "返回上一级",Snackbar.LENGTH_INDEFINITE).show();
            }
        });
        titleBarView.getTitleRightBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "点我分享",Snackbar.LENGTH_INDEFINITE).show();
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mPercentView = (PercentView) findViewById(R.id.percentView);
        mPercentView.invalidate();
    }

}
