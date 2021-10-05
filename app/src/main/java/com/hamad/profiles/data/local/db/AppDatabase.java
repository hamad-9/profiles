package com.hamad.profiles.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.hamad.profiles.data.local.db.dao.UserDao;
import com.hamad.profiles.data.model.db.User;


//@Database(entities = {User.class, Entity.class}, version = 2)
@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
