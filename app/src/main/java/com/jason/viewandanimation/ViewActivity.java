package com.jason.viewandanimation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.jason.viewandanimation.R;
import com.jason.viewandanimation.view.PercentView;

public class ViewActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private PercentView mPercentView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_1:
                    mPercentView.invalidate();
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_2:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_3:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mPercentView = (PercentView) findViewById(R.id.percentView);
        mPercentView.invalidate();
    }

}
