package com.hamad.profiles.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hamad.profiles.data.model.db.User;

import java.util.List;

import io.reactivex.Single;


@Dao
public interface UserDao {

    @Delete
    void delete(User user);

    @Query("SELECT * FROM users WHERE username LIKE :name LIMIT 1")
    Single<User> findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);

    @Query("SELECT * FROM users")
    List<User> loadAll();

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    List<User> loadAllByIds(List<Integer> userIds);
}
