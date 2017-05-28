package com.example.theseus.pomodoro.model.db;

import android.content.Context;

import com.example.theseus.pomodoro.dagger.ApplicationContext;
import com.example.theseus.pomodoro.dagger.DatabaseInfo;
import com.example.theseus.pomodoro.model.db.model.DaoMaster;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by theseus on 28/5/17.
 */
@Singleton
public class DBOpenHelper extends DaoMaster.OpenHelper {
    @Inject
    public DBOpenHelper(@ApplicationContext Context context,@DatabaseInfo String name) {
        super(context, name);
    }

    /**
     * Override this if you do not want to depend on {@link SQLiteDatabase}.
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
