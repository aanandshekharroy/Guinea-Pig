package com.example.theseus.pomodoro.ui.home;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.theseus.pomodoro.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by theseus on 29/5/17.
 */
@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {
    @Rule
    public ActivityTestRule<HomeActivity> mHomeActivityRule =
            new ActivityTestRule<>(HomeActivity.class);
    @Test
    public void checkIfWorkTimerStartsOnClickButton(){
        onView(withId(R.id.start_timer)).perform(click());
//        verify()
    }
}