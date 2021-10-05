package com.hamad.profiles.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "users")
public class User {

    @PrimaryKey
    public Long id;

    public String username;

    public String email;


}
