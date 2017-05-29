package com.example.theseus.pomodoro;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by theseus on 29/5/17.
 */
public class UtilitiesTest {
    @Test
    public void checkIfTimeStringFromMillsecondsWorkingFine(){
        assertEquals(Utilities.getTimeStringFromMilliseconds(150000),"2 mm 30 ss");
    }
}