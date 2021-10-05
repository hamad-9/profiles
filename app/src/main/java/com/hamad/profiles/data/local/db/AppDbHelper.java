package com.hamad.profiles.data.local.db;


import com.hamad.profiles.data.model.db.User;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton//this layer is a link between local database and outside world.
          //this layer deal with "entities daos" and the upper layer deal with "this layer".
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }


}
