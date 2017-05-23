package com.example.theseus.pomodoro.view;

import android.support.v7.app.AppCompatActivity;

import com.example.theseus.pomodoro.dagger.components.ActivityComponent;
import com.example.theseus.pomodoro.dagger.components.DaggerActivityComponent;
import com.example.theseus.pomodoro.presenter.HomePresenterInterface;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.theseus.pomodoro.R;
import com.example.theseus.pomodoro.dagger.modules.ActivityModule;
import com.example.theseus.pomodoro.model.CountdownEvent;
import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import timber.log.Timber;

public class HomeActivity extends AppCompatActivity implements HomeView {
    @BindView(R.id.start_timer)
    Button start_timer;
    @BindView(R.id.timer_view)
    TextView timer_view;
    @Inject
    FragmentManager fragmentManager;
    @Inject
    RewardsFragment rewardsFragment;
    @Inject
    HomePresenterInterface homePresenter;
    Subscription subscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActivityComponent component= DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .build();
        component.inject(this);

        if(savedInstanceState==null){
            homePresenter.setupWorkTimer();
        }
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        subscription= RxView.clicks(start_timer)
                .subscribe(aVoid -> {
//                    Toast.makeText(MainActivity.this, "RxView.clicks", Toast.LENGTH_SHORT).show();
                    homePresenter.startTimerClicked(timer_view.getText().toString());
                });
        EventBus.getDefault().register(this);
    }
    @Subscribe
    public void onLocationEvent(CountdownEvent event) {
    /* Do what you need to */
        homePresenter.updateTimerText(event);

    };
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
//        fragmentManager
        Timber.d("null:"+(fragmentManager==null));
        rewardsFragment.show(fragmentManager,"RewardsFragment");
//        rewardsFragment.

    }

    @Override
    public void dismissRewardsFragment() {
        rewardsFragment.dismiss();
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
        Timber.d("setTimerText: "+text);
        timer_view.setText(text);
    }
}
