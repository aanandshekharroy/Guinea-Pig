package com.example.theseus.pomodoro.ui.home;

import com.example.theseus.pomodoro.model.DataManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.android.plugins.RxAndroidPlugins;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by theseus on 29/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class HomePresenterTest {
    @Mock
    HomeView mHomeView;
    @Mock
    DataManager mDataManger;
    private HomePresenterInterface<HomeView> mHomePresenter;
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mHomePresenter=new HomePresenter<>(mDataManger);
        mHomePresenter.onAttach(mHomeView);
    }
    @Test
    public void checkIfSetTimerTextWorks(){
        when(mDataManger.getWorkDurationText()).thenReturn("25:00");
        mHomePresenter.setupWorkTimer();
        verify(mHomeView).setTimerText("25:00");
    }
    @After
    public void tearDown() throws Exception {
        mHomePresenter.onDetach();
    }
}