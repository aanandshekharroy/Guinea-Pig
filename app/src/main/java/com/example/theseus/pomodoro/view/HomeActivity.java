package com.example.theseus.pomodoro.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.theseus.pomodoro.PomodoroApplication;
import com.example.theseus.pomodoro.R;
import com.example.theseus.pomodoro.presenter.HomePresenter;
import com.example.theseus.pomodoro.presenter.HomePresenterInterface;
import com.example.theseus.pomodoro.view.HomeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements HomeView {
    HomePresenterInterface homePresenter;
    @BindView(R.id.start_timer)
    Button start_timer;
    @BindView(R.id.timer_view)
    TextView timer_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(savedInstanceState==null){
            homePresenter=new HomePresenter();
            homePresenter.setupWorkTimer(this);
        }
    }
    @OnClick(R.id.start_timer)
    public void onStartTimer(){
        homePresenter.startTimerClicked(timer_view.getText().toString());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void inflateRewardFragment() {

    }

    @Override
    public void setupTimer(int duration) {
        if((start_timer.getText()).equals("Start")){

        }
    }

    @Override
    public void setButtonTag(String tag) {
        start_timer.setTag(tag);
    }
    @Override
    public String getButtonTag(String tag) {
        return start_timer.getTag().toString();
    }

    @Override
    public void setTimerText(String text) {
        timer_view.setText(text);
    }
}
